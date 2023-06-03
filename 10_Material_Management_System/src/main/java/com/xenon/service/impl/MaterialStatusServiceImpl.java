package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.MaterialStatus;
import com.xenon.service.MaterialStatusService;
import com.xenon.mapper.MaterialStatusMapper;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
 * @author Xenon
 * @description 针对表【material_status】的数据库操作Service实现
 * @createDate 2023-06-01 13:33:42
 */
@Service
public class MaterialStatusServiceImpl extends ServiceImpl<MaterialStatusMapper, MaterialStatus> implements MaterialStatusService
{

    public Result getAllMaterialStatus()
    {
        return Result.pass("物资状态字典已传输").data("data", this.list());
    }

    public Result saveMaterialStatus(MaterialStatus materialStatus)
    {

        return Result.pass("物资状态字典已收录新物资状态").data("data", this.saveOrUpdate(materialStatus));
    }

    public Result updateMaterialStatus(MaterialStatus materialStatus)
    {
        return Result.pass("物资状态字典已更新物资状态").data("data", this.saveOrUpdate(materialStatus));
    }

    public Result deleteMaterialStatus(Integer materialStatusId)
    {
        boolean remove;
        try{
            remove = this.removeById(materialStatusId);
        }catch (Exception e)
        {
            return Result.errorFK();
        }
        return Result.pass("物资状态字典已删除物资状态").data("data", remove);
    }
}




