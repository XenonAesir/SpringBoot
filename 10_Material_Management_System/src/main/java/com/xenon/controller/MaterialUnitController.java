package com.xenon.controller;

import com.xenon.entity.MaterialUnit;
import com.xenon.service.impl.MaterialUnitServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materialUnit")
@CrossOrigin
@Api(tags = "物资字典—单位")
public class MaterialUnitController
{

    @Autowired
    MaterialUnitServiceImpl materialUnitService;

    @ApiOperation("获取全部的物资单位字典")
    @GetMapping("/all")
    public Result getAllMaterialUnit()
    {
        return materialUnitService.getAllMaterialUnit();
    }

    @ApiOperation("传递MaterialUnit对象存储到数据库")
    @ApiImplicitParam(name = "materialUnit", value = "MaterialUnit对象", paramType = "body", required = true, dataType = "MaterialUnit")
    @PostMapping("/save")
    public Result saveMaterialUnit(@RequestBody MaterialUnit materialUnit)
    {
        return materialUnitService.saveMaterialUnit(materialUnit);
    }

    @ApiOperation("传递MaterialUnit对象进行更新修改")
    @ApiImplicitParam(name = "materialUnit", value = "MaterialUnit对象", paramType = "body", required = true, dataType = "MaterialUnit")
    @PutMapping("/update")
    public Result updateMaterialUnit(@RequestBody MaterialUnit materialUnit)
    {
        return materialUnitService.updateMaterialUnit(materialUnit);
    }

    @ApiOperation("根据MaterialUnit对象Id从数据库删除")
    @ApiImplicitParam(name = "materialUnitId", value = "materialUnit的Id值", paramType = "query", required = true, dataType = "Integer")
    @DeleteMapping("/delete/{materialUnitId}")
    public Result deleteMaterialUnit(@PathVariable Integer materialUnitId)
    {
        return materialUnitService.deleteMaterialUnit(materialUnitId);
    }
}
