package com.xenon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xenon.entity.Order;
import com.xenon.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User>
{
    // 通过用户id查找用户
    @Select("SELECT * FROM m_user WHERE user_id=#{userId}")
    User selectByUserId(int userId);

    // 一个用户可能有多个订单
    @Select("SELECT * FROM m_user")
    @Results
    (
        {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "user_id", property = "orders",
                    many = @Many(select = "com.xenon.mapper.OrderMapper.selectByConsumerId")),
        }
    )
    List<User> getAllUsers();
}
