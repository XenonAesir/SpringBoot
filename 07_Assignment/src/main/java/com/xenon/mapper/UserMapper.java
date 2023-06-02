package com.xenon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xenon.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>
{
}
