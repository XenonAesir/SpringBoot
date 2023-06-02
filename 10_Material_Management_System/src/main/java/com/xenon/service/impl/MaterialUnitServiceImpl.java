package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.MaterialUnit;
import com.xenon.service.MaterialUnitService;
import com.xenon.mapper.MaterialUnitMapper;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【material_unit】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class MaterialUnitServiceImpl extends ServiceImpl<MaterialUnitMapper, MaterialUnit>
    implements MaterialUnitService{

}




