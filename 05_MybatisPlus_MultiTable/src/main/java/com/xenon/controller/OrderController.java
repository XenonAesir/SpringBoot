package com.xenon.controller;

import com.xenon.entity.Order;
import com.xenon.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/")
    public List<Order> getAllOrders()
    {
        return orderMapper.getAllOrders();
    }
}
