package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Material;
import com.xenon.entity.Provision;
import com.xenon.mapper.ProvisionMapper;
import com.xenon.service.MaterialService;
import com.xenon.mapper.MaterialMapper;
import com.xenon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Xenon
 * @description 针对表【material】的数据库操作Service实现
 * @createDate 2023-05-30 22:23:52
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService
{
    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    ProvisionMapper provisionMapper;

    /***
     * 获取全部设备信息
     * @return 操作结果
     */
    public Result getAllMaterialsAllInfo()
    {
        List<Material> allMaterialsAndSuppliers = materialMapper.selectMaterialAndSupplier(new Material());
        return Result.pass()
                .data("data", allMaterialsAndSuppliers);
    }

    /***
     * 根据结果查询设备信息
     * @param material 查询条件
     * @return 操作结果
     */
    public Result getMaterialsBy(Material material)
    {
        List<Material> queryResult = materialMapper.selectMaterialAndSupplier(material);
        return Result.pass()
                .data("data", queryResult);
    }

    /***
     * 添加设备，关联修改provision表中的信息
     * @param material 设备信息，其中supplier.supplierId必填，默认应为1，表示管理员添加
     * @return 操作结果
     */
    public Result saveMaterial(Material material)
    {

        // 插入 material 表
        this.saveOrUpdate(material);

        // 获取插入后的自动生成的 id 值
        Integer materialId = material.getMaterialId();

        // 设置 provision 的 信息
        Provision provision = new Provision();
        provision.setMaterialId(materialId);
        provision.setSupplierId(material.getSupplier().getSupplierId());

        // 插入 provision 表
        provisionMapper.insert(provision);

        return Result.pass("新增设备成功");
    }

    /***
     * 更新设备，关联更新provision表中的信息
     * @param material 设备信息，其中supplier.supplierId非必填
     * @return 操作结果
     */
    public Result updateMaterial(Material material)
    {
        // 更新信息
        this.saveOrUpdate(material);

        // 确定provision信息
        Provision provision = new Provision();
        provision.setMaterialId(material.getMaterialId());
        provision.setSupplierId(material.getSupplier().getSupplierId());

        // 更新provision信息
        provisionMapper.update(provision,new QueryWrapper<Provision>().eq("material_id", provision.getMaterialId()));

        return Result.pass("修改信息成功");
    }

    public Result deleteMaterial(Integer materialId)
    {
        // 移除设备信息
        this.removeById(materialId);

        return Result.pass("删除设备成功");
    }


}




