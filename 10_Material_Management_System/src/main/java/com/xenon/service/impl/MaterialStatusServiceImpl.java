package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.MaterialStatus;
import com.xenon.service.MaterialStatusService;
import com.xenon.mapper.MaterialStatusMapper;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【material_status】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class MaterialStatusServiceImpl extends ServiceImpl<MaterialStatusMapper, MaterialStatus>
    implements MaterialStatusService{

}




