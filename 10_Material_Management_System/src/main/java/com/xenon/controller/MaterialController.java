package com.xenon.controller;

import com.xenon.entity.Material;
import com.xenon.service.impl.MaterialServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/material")
@CrossOrigin
@Api(tags = "物资管理")
public class MaterialController
{
    @Autowired
    MaterialServiceImpl materialServiceImpl;

    @ApiOperation("获取全部物资及其供应商信息")
    @GetMapping("/all")
    public Result getAllMaterialsAllInfo()
    {
        return materialServiceImpl.getAllMaterialsAllInfo();
    }

    @ApiOperation("传递Material对象查询结果")
    @ApiImplicitParam(name = "material", value = "Material对象", paramType = "body", required = true, dataType = "Material")
    @PostMapping("/search")
    public Result getMaterialsBy(@RequestBody Material material)
    {
        return materialServiceImpl.getMaterialsBy(material);
    }

    @ApiOperation("传递Material对象存储到数据库")
    @ApiImplicitParam(name = "material", value = "Material对象", paramType = "body", required = true, dataType = "Material")
    @PostMapping("/save")
    public Result saveMaterial(@RequestBody Material material)
    {
        return materialServiceImpl.saveMaterial(material);
    }

    @ApiOperation("传递Material对象进行更新修改")
    @ApiImplicitParam(name = "material", value = "Material对象", paramType = "body", required = true, dataType = "Material")
    @PutMapping("/update")
    public Result updateMaterial(@RequestBody Material material)
    {
        return materialServiceImpl.updateMaterial(material);
    }

    @ApiOperation("根据Material对象Id从数据库删除")
    @ApiImplicitParam(name = "materialId", value = "material的Id值", paramType = "query", required = true, dataType = "Integer")
    @DeleteMapping("/delete/{materialId}")
    public Result deleteMaterial(@PathVariable Integer materialId)
    {
        return materialServiceImpl.deleteMaterial(materialId);
    }

}
