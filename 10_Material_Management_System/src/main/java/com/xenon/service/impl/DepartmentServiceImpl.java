package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Department;
import com.xenon.service.DepartmentService;
import com.xenon.mapper.DepartmentMapper;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【department】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

    public Result getAllDepartment()
    {
        return Result.pass().data("data", this.list());
    }
}




