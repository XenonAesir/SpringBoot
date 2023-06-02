package com.xenon.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xenon.entity.Order;
import com.xenon.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order>
{
    // 通过消费者id查询订单
    @Select("SELECT * FROM m_order WHERE consumer=#{consumer}")
    List<Order> selectByConsumerId(int consumer);

    // 每个订单对应一个用户
    @Select("SELECT * FROM m_order")
    @Results
    (
        {
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_name", property = "orderName"),
            @Result(column = "consumer", property = "consumer", javaType = User.class,
            one = @One(select = "com.xenon.mapper.UserMapper.selectByUserId")),
        }
    )
    List<Order> getAllOrders();

}
