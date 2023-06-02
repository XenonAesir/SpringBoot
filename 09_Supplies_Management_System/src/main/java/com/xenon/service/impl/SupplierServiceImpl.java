package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Supplier;
import com.xenon.service.SupplierService;
import com.xenon.mapper.SupplierMapper;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【supplier】的数据库操作Service实现
* @createDate 2023-05-30 22:23:52
*/
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier>
    implements SupplierService{

}




