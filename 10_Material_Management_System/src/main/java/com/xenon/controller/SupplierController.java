package com.xenon.controller;

import com.xenon.entity.Supplier;
import com.xenon.service.impl.SupplierServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
@Api(tags = "物资供应商")
public class SupplierController
{

    @Autowired
    SupplierServiceImpl supplierService;

    @ApiOperation("获取全部的供应商")
    @GetMapping("/all")
    public Result getAllSupplier()
    {
        return supplierService.getAllSupplier();
    }

    @ApiOperation("传递Supplier对象存储到数据库")
    @ApiImplicitParam(name = "supplier", value = "Supplier对象", paramType = "body", required = true, dataType = "Supplier")
    @PostMapping("/save")
    public Result saveSupplier(@RequestBody Supplier supplier)
    {
        return supplierService.saveSupplier(supplier);
    }

    @ApiOperation("传递Supplier对象进行更新修改")
    @ApiImplicitParam(name = "supplier", value = "Supplier对象", paramType = "body", required = true, dataType = "Supplier")
    @PutMapping("/update")
    public Result updateSupplier(@RequestBody Supplier supplier)
    {
        return supplierService.updateSupplier(supplier);
    }

    @ApiOperation("根据Supplier对象Id从数据库删除")
    @ApiImplicitParam(name = "supplierId", value = "supplier的Id值", paramType = "query", required = true, dataType = "Integer")
    @DeleteMapping("/delete/{supplierId}")
    public Result deleteSupplier(@PathVariable Integer supplierId)
    {
        return supplierService.deleteSupplier(supplierId);
    }
}
