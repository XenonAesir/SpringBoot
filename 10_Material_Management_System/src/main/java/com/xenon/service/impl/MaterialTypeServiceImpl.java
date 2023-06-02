package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.MaterialType;
import com.xenon.service.MaterialTypeService;
import com.xenon.mapper.MaterialTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【material_type】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class MaterialTypeServiceImpl extends ServiceImpl<MaterialTypeMapper, MaterialType>
    implements MaterialTypeService{

}




