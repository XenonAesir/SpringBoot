package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Allocation;
import com.xenon.service.AllocationService;
import com.xenon.mapper.AllocationMapper;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【allocation】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class AllocationServiceImpl extends ServiceImpl<AllocationMapper, Allocation>
    implements AllocationService{

}




