package com.xenon.mapper;

import com.xenon.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Xenon
* @description 针对表【department】的数据库操作Mapper
* @createDate 2023-06-01 13:33:42
* @Entity com.xenon.entity.Department
*/
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

}




