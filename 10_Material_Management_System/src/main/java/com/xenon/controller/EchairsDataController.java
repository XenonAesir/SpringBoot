package com.xenon.controller;

import com.xenon.service.impl.MaterialServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echairs")
@CrossOrigin
@Api(tags = "统计报表数据")
public class EchairsDataController
{

    @Autowired
    MaterialServiceImpl materialServiceImpl;

    @ApiOperation("获取所有Material对象状态数目")
    @GetMapping("/material")
    public Result getAllMaterialData()
    {
        return materialServiceImpl.getAllMaterialData();
    }
}
