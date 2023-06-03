package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.MaterialUnit;
import com.xenon.service.MaterialUnitService;
import com.xenon.mapper.MaterialUnitMapper;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【material_unit】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class MaterialUnitServiceImpl extends ServiceImpl<MaterialUnitMapper, MaterialUnit>
    implements MaterialUnitService{

    public Result getAllMaterialUnit()
    {
        return Result.pass("物资单位字典已传输").data("data", this.list());
    }

    public Result saveMaterialUnit(MaterialUnit materialUnit)
    {
        return Result.pass("物资单位字典已收录新物资单位").data("data", this.saveOrUpdate(materialUnit));

    }

    public Result updateMaterialUnit(MaterialUnit materialUnit)
    {
        return Result.pass("物资单位字典已更新物资单位").data("data", this.saveOrUpdate(materialUnit));

    }

    public Result deleteMaterialUnit(Integer materialUnitId)
    {
        boolean remove;
        try{
            remove = this.removeById(materialUnitId);
        }catch (Exception e)
        {
            return Result.errorFK();
        }
        return Result.pass("物资单位字典已删除物资单位").data("data", remove);
    }
}




