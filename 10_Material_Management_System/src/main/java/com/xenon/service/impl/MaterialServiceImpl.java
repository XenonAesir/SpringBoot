package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.echarts.FormData;
import com.xenon.entity.*;
import com.xenon.mapper.*;
import com.xenon.service.MaterialService;
import com.xenon.utils.Result;
import com.xenon.utils.StaticVariable;
import com.xenon.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xenon
 * @description 针对表【material】的数据库操作Service实现
 * @createDate 2023-06-01 13:33:42
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService
{
    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    SupplierMapper supplierMapper;
    // @Autowired
    // AdminMapper adminMapper;
    @Autowired
    MaterialTypeMapper materialTypeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AllocationMapper allocationMapper;

    @Autowired
    MaterialStatusServiceImpl materialStatusService;


    /***
     * 获取全部设备全部信息
     * @return 操作结果
     */
    public Result getAllMaterialsAllInfo()
    {
        List<Material> allMaterials = this.list();

        for (Material material : allMaterials)
        {
            // material.setAdmin(adminMapper.selectById(material.getAdminId()));
            material.setSupplier(supplierMapper.selectById(material.getSupplierId()));
            // material.setMaterialStatus(materialStatusMapper.selectById(material.getMaterialStatusId()));
            // material.setMaterialType(materialTypeMapper.selectById(material.getMaterialTypeId()));
            // material.setMaterialUnit(materialUnitMapper.selectById(material.getMaterialUnitId()));
        }

        return Result.pass()
                .data("data", allMaterials);
    }

    /***
     * 根据结果查询设备信息
     * @param material 查询条件
     * @return 操作结果
     */
    public Result getMaterialsBy(Material material)
    {

        QueryWrapper<Material> wrapper = new QueryWrapper<>();// 构建一个查询的wrapper
        Map<String, Object> map = new HashMap<>()
        {
            {
                put("material_id", material.getMaterialId());
                put("material_unit_id", material.getMaterialUnitId());
                put("material_status_id", material.getMaterialStatusId());
                put("material_type_id", material.getMaterialTypeId());
                put("is_allocated", material.getIsAllocated());
                put("is_asset", material.getIsAsset());
            }
        };

        wrapper
                .allEq(map, false)
                .like("material_name", material.getMaterialName());


        List<Material> allMaterials = materialMapper.selectList(wrapper);
        for (Material material0 : allMaterials)
        {
            // material.setAdmin(adminMapper.selectById(material.getAdminId()));
            material0.setSupplier(supplierMapper.selectById(material0.getSupplierId()));
            // material.setMaterialStatus(materialStatusMapper.selectById(material.getMaterialStatusId()));
            // material.setMaterialType(materialTypeMapper.selectById(material.getMaterialTypeId()));
            // material.setMaterialUnit(materialUnitMapper.selectById(material.getMaterialUnitId()));
        }


        return Result.pass()
                .data("data", allMaterials);
    }

    /***
     * 添加设备，关联修改表中的信息
     * @param material 设备信息
     * @return 操作结果
     */
    public Result saveMaterial(Material material)
    {

        System.out.println(material);

        MaterialType materialType = materialTypeMapper.selectById(material.getMaterialTypeId());
        if (materialType.getMaterialTypeAsset() == 1)
        {
            material.setIsAsset(1);
            material.setAssetNumber(UUIDUtils.generateUniqueKeyMD5());
        }
        else
        {
            material.setIsAsset(0);
        }

        try
        {
            material.setAdminId(StaticVariable.ADMIN_ID);
            // 插入 material 表
            this.saveOrUpdate(material);

        }
        catch (Exception e)
        {
            return Result.errorIC();
        }

        return Result.pass("新增设备成功");
    }

    /***
     * 更新设备
     * @param material 设备信息
     * @return 操作结果
     */
    public Result updateMaterial(Material material)
    {

        System.out.println(material);

        MaterialType materialType = materialTypeMapper.selectById(material.getMaterialTypeId());
        if (materialType.getMaterialTypeAsset() == 1)
        {
            material.setIsAsset(1);
            material.setAssetNumber(UUIDUtils.generateUniqueKeyMD5());
        }
        else
        {
            material.setIsAsset(0);
            material.setAssetNumber("");
        }

        // 更新信息
        try
        {
            this.saveOrUpdate(material);
        }
        catch (Exception e)
        {
            return Result.errorIC();
        }
        return Result.pass("修改信息成功");
    }

    /***
     * 删除设备
     * @param materialId 设备ID
     * @return 操作结果
     */
    public Result deleteMaterial(Integer materialId)
    {

        Material material = this.getById(materialId);
        if (material != null)
        {
            if (material.getIsAllocated() == 1)
            {
                return Result.error("删除失败，设备尚未入库");
            }
            else
            {
                this.removeById(materialId);
                return Result.pass("删除信息成功");
            }
        }
        else
        {
            return Result.error("删除失败，设备不存在");
        }

    }

    /***
     * 统计物资信息
     * @return 操作结果
     */
    public Result getAllMaterialData()
    {
        // 三种统计数据
        ArrayList<FormData> statusList = new ArrayList<>();
        ArrayList<FormData> departmentPriceAmountList = new ArrayList<>();
        ArrayList<ArrayList<?>> departmentMaterialAmountList = new ArrayList<>();

        ArrayList<String> departmentList = new ArrayList<>();
        ArrayList<Integer> materialAmountList = new ArrayList<>();

        // 一个循环代表一个连接操作

        // 查询状态-物资之间的关系
        for (MaterialStatus materialStatus : materialStatusService.list())
        {
            statusList.add(new FormData(
                            materialStatus.getMaterialStatusName(),
                            this.count(new QueryWrapper<Material>().eq("material_status_id", materialStatus.getMaterialStatusId())))
                    );
        }

        // 查询部门-用户-分配-物资之间的关系
        for (Department department : departmentMapper.selectList(null))
        {
            BigDecimal priceAmount = new BigDecimal("0.00");
            Integer materialCounter = 0;
            for (User user : userMapper.selectList(new QueryWrapper<User>().eq("department_id", department.getDepartmentId())))
            {
                for (Allocation allocation : allocationMapper.selectList(new QueryWrapper<Allocation>().eq("user_id", user.getUserId())))
                {
                    BigDecimal materialPrice = materialMapper.selectById(allocation.getMaterialId()).getMaterialPrice();
                    priceAmount = priceAmount.add(materialPrice);
                    materialCounter++;
                }


            }
            departmentPriceAmountList.add(new FormData(
                    department.getDepartmentName(),
                    priceAmount
                    ));


            departmentList.add(department.getDepartmentName());
            materialAmountList.add(materialCounter);

        }

        departmentMaterialAmountList.add(departmentList);
        departmentMaterialAmountList.add(materialAmountList);

        return Result.pass()
                .data("statusList", statusList)
                .data("departmentPriceAmountList", departmentPriceAmountList)
                .data("departmentMaterialAmountList", departmentMaterialAmountList);
    }
}




