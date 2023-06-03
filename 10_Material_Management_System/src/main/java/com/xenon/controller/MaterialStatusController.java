package com.xenon.controller;

import com.xenon.entity.MaterialStatus;
import com.xenon.service.impl.MaterialStatusServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materialStatus")
@CrossOrigin
@Api(tags = "物资状态字典")
public class MaterialStatusController
{
    
    @Autowired
    MaterialStatusServiceImpl materialStatusStatusService;

    @ApiOperation("获取全部的物资状态字典")
    @GetMapping("/all")
    public Result getAllMaterialStatus()
    {
        return materialStatusStatusService.getAllMaterialStatus();
    }

    @ApiOperation("传递MaterialStatus对象存储到数据库")
    @ApiImplicitParam(name = "materialStatus", value = "MaterialStatus对象", paramType = "body", required = true, dataType = "MaterialStatus")
    @PostMapping("/save")
    public Result saveMaterialStatus(@RequestBody MaterialStatus materialStatus)
    {
        return materialStatusStatusService.saveMaterialStatus(materialStatus);
    }

    @ApiOperation("传递MaterialStatus对象进行更新修改")
    @ApiImplicitParam(name = "materialStatus", value = "MaterialStatus对象", paramType = "body", required = true, dataType = "MaterialStatus")
    @PutMapping("/update")
    public Result updateMaterialStatus(@RequestBody MaterialStatus materialStatus)
    {
        return materialStatusStatusService.updateMaterialStatus(materialStatus);
    }

    @ApiOperation("根据MaterialStatus对象Id从数据库删除")
    @ApiImplicitParam(name = "materialStatusId", value = "materialStatus的Id值", paramType = "query", required = true, dataType = "Integer")
    @DeleteMapping("/delete/{materialStatusId}")
    public Result deleteMaterialStatus(@PathVariable Integer materialStatusId)
    {
        return materialStatusStatusService.deleteMaterialStatus(materialStatusId);
    }
}
