package com.xenon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xenon.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

// IDEA不加下面两者之一的注解无法使用MapperScan
// @Mapper
@Repository
// 在继承mybatis-plus的BaseMapper类后，可以直接调用其中的方法
public interface UserMapper extends BaseMapper<User>
{
    @Select("SELECT * FROM user")
    List<User> getAllUser();

    @Select("SELECT * FROM user WHERE userid=#{userID}")
    List<User> getUserByUserId(Integer userID);

    @Insert("INSERT INTO user VALUES(#{userID},#{userName},#{userPassword})")
    int addUser(User user);

    @Update("UPDATE user SET userName=#{userName},userPassword=#{userPassword} WHERE userID=#{userID}")
    int updateUser(User user);

    @Delete("DELETE FROM user WHERE userID=#{userID}")
    int deleteUser(Integer user);

}
