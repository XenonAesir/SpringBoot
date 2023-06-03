package com.xenon.controller;

import com.xenon.entity.MaterialType;
import com.xenon.service.impl.MaterialTypeServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materialType")
@CrossOrigin
@Api(tags = "物资状态字典")
public class MaterialTypeController
{

    @Autowired
    MaterialTypeServiceImpl materialTypeTypeService;

    @ApiOperation("获取全部的物资状态字典")
    @GetMapping("/all")
    public Result getAllMaterialType()
    {
        return materialTypeTypeService.getAllMaterialType();
    }

    @ApiOperation("传递MaterialType对象存储到数据库")
    @ApiImplicitParam(name = "materialType", value = "MaterialType对象", paramType = "body", required = true, dataType = "MaterialType")
    @PostMapping("/save")
    public Result saveMaterialType(@RequestBody MaterialType materialType)
    {
        return materialTypeTypeService.saveMaterialType(materialType);
    }

    @ApiOperation("传递MaterialType对象进行更新修改")
    @ApiImplicitParam(name = "materialType", value = "MaterialType对象", paramType = "body", required = true, dataType = "MaterialType")
    @PutMapping("/update")
    public Result updateMaterialType(@RequestBody MaterialType materialType)
    {
        return materialTypeTypeService.updateMaterialType(materialType);
    }

    @ApiOperation("根据MaterialType对象Id从数据库删除")
    @ApiImplicitParam(name = "materialTypeId", value = "materialType的Id值", paramType = "query", required = true, dataType = "Integer")
    @DeleteMapping("/delete/{materialTypeId}")
    public Result deleteMaterialType(@PathVariable Integer materialTypeId)
    {
        return materialTypeTypeService.deleteMaterialType(materialTypeId);
    }
}
