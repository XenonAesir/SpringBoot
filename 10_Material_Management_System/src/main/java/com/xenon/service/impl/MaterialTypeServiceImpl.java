package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.MaterialType;
import com.xenon.service.MaterialTypeService;
import com.xenon.mapper.MaterialTypeMapper;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
 * @author Xenon
 * @description 针对表【material_type】的数据库操作Service实现
 * @createDate 2023-06-01 13:33:42
 */
@Service
public class MaterialTypeServiceImpl extends ServiceImpl<MaterialTypeMapper, MaterialType> implements MaterialTypeService
{

    public Result getAllMaterialType()
    {
        return Result.pass("物资类型字典已传输").data("data", this.list());
    }

    public Result saveMaterialType(MaterialType materialType)
    {

        return Result.pass("物资类型字典已收录新物资类型").data("data", this.saveOrUpdate(materialType));
    }

    public Result updateMaterialType(MaterialType materialType)
    {
        return Result.pass("物资类型字典已更新物资类型").data("data", this.saveOrUpdate(materialType));
    }

    public Result deleteMaterialType(Integer materialTypeId)
    {
        boolean remove;
        try{
            remove = this.removeById(materialTypeId);
        }catch (Exception e)
        {
            return Result.errorFK();
        }
        return Result.pass("物资类型字典已删除物资类型").data("data", remove);
    }
}




