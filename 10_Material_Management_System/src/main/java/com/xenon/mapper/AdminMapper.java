package com.xenon.mapper;

import com.xenon.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Xenon
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-06-01 13:33:42
* @Entity com.xenon.entity.Admin
*/
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

}




