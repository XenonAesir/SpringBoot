package com.xenon.mapper;

import com.xenon.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper
{
    @Select("SELECT * FROM m_user WHERE user_id=#{userId}")
    User selectByUserId(Integer userId);

    @Select("SELECT * FROM m_user")
    @Results
    (
        {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "user_id", property = "orderList",
                    many = @Many(select = "com.xenon.mapper.OrderMapper.selectByConsumerId"))
        }
    )
    List<User> getAllUsers();
}
