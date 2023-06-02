package com.xenon.mapper;

import com.xenon.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Xenon
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-01 13:33:42
* @Entity com.xenon.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




