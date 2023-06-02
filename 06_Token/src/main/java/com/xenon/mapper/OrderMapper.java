package com.xenon.mapper;

import com.xenon.entity.Order;
import com.xenon.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper
{
    // @Select("SELECT * FROM m_order WHERE consumer=#{consumerID}")
    // List<Order> selectByConsumerId(Integer consumerID);
    //
    // @Select("SELECT * FROM m_order")
    // @Results
    // (
    //     {
    //         @Result(column = "order_id", property = "orderId"),
    //         @Result(column = "order_name", property = "orderName"),
    //         @Result(column = "consumer", property = "consumer", javaType = User.class,
    //                 one = @One(select = "com.xenon.mapper.UserMapper.selectByUserId"))
    //     }
    // )
    // List<Order> getAllOrders();
}
