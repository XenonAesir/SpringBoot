package com.xenon.controller;

import com.xenon.entity.Allocation;
import com.xenon.service.impl.AllocationServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocation")
@CrossOrigin
@Api(tags = "分配管理")
public class AllocationController
{
    @Autowired
    AllocationServiceImpl allocationImpl;

    @ApiOperation("获取全部分配")
    @GetMapping("/all")
    public Result getAllAllocationsAllInfo()
    {
        return allocationImpl.getAllAllocationsAllInfo();
    }

    // @ApiOperation("传递Allocation对象查询结果")
    // @ApiImplicitParam(name = "allocation", value = "Allocation对象", paramType = "body", required = true, dataType = "Allocation")
    // @PostMapping("/search")
    // public Result getAllocationsBy(@RequestBody Allocation allocation)
    // {
    //     return allocationImpl.getAllocationsBy(allocation);
    // }

    @ApiOperation("传递Allocation对象存储到数据库")
    @ApiImplicitParam(name = "allocation", value = "Allocation对象", paramType = "body", required = true, dataType = "Allocation")
    @PostMapping("/save")
    public Result saveAllocation(@RequestBody Allocation allocation)
    {
        return allocationImpl.saveAllocation(allocation);
    }

    // @ApiOperation("传递Allocation对象进行更新修改")
    // @ApiImplicitParam(name = "allocation", value = "Allocation对象", paramType = "body", required = true, dataType = "Allocation")
    // @PutMapping("/update")
    // public Result updateAllocation(@RequestBody Allocation allocation)
    // {
    //     return allocationImpl.updateAllocation(allocation);
    // }

    @ApiOperation("根据Allocation对象Id从数据库删除")
    @ApiImplicitParam(name = "allocationId", value = "allocation的Id值", paramType = "query", required = true, dataType = "Integer")
    @DeleteMapping("/delete/{allocationId}")
    public Result deleteAllocation(@PathVariable Integer allocationId)
    {
        return allocationImpl.deleteAllocation(allocationId);
    }

}
