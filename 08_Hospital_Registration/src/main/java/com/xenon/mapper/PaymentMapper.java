package com.xenon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.xenon.entity.Payment;

@Repository
public interface PaymentMapper extends BaseMapper<Payment>
{
}
