package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Material;
import com.xenon.mapper.*;
import com.xenon.service.MaterialService;
import com.xenon.utils.Result;
import com.xenon.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (material.getIsAsset() == 1)
        {
            material.setAssetNumber(UUIDUtils.generateUniqueKeyMD5());
        }

        try
        {
            // 插入 material 表
            this.saveOrUpdate(material);
        }catch (Exception e)
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
        // 更新信息
        try
        {
            if (material.getIsAsset() != null || material.getAssetNumber() != null)
            {
                return Result.error("不允许修改资产类型及ID");
            }
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

}




