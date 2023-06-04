package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Allocation;
import com.xenon.entity.Material;
import com.xenon.mapper.AdminMapper;
import com.xenon.mapper.MaterialMapper;
import com.xenon.mapper.UserMapper;
import com.xenon.service.AllocationService;
import com.xenon.mapper.AllocationMapper;
import com.xenon.utils.Result;
import com.xenon.utils.StaticVariable;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Xenon
 * @description 针对表【allocation】的数据库操作Service实现
 * @createDate 2023-06-01 13:33:42
 */
@Service
public class AllocationServiceImpl extends ServiceImpl<AllocationMapper, Allocation>
        implements AllocationService
{

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AllocationMapper allocationMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MaterialMapper materialMapper;

    public Result getAllAllocationsAllInfo()
    {
        List<Allocation> allAllocation = this.list();

        for (Allocation allocation : allAllocation)
        {
            allocation.setAdmin(adminMapper.selectById(allocation.getAdminId()));
            allocation.setMaterial(materialMapper.selectById(allocation.getMaterialId()));
            allocation.setUser(userMapper.selectById(allocation.getUserId()));
        }

        return Result.pass()
                .data("data", allAllocation);
    }

    public Result saveAllocation(Allocation allocation)
    {

        Material material = materialMapper.selectById(allocation.getMaterialId());
        if (material.getIsAllocated() == 1)
        {
            return Result.error("设备已被分配无法再分配");
        }

        try
        {
            allocation.setAllocationDate(LocalDateTime.now());
            allocation.setAdminId(StaticVariable.ADMIN_ID);
            // 插入 allocation 表
            this.saveOrUpdate(allocation);
        }
        catch (Exception e)
        {
            return Result.errorIC();
        }

        material.setIsAllocated(1);
        materialMapper.updateById(material);

        return Result.pass("分配设备成功");
    }


    public Result deleteAllocation(Integer allocationId)
    {
        Allocation allocation = this.getById(allocationId);
        if (allocation != null)
        {
            Material material = new Material();
            material.setMaterialId(allocation.getMaterialId());
            material.setIsAllocated(0);

            this.removeById(allocationId);
            materialMapper.updateById(material);

            return Result.pass("删除分配信息成功");

        }
        else
        {
            return Result.error("删除失败，分配不存在");
        }
    }
}




