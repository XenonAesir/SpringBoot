package com.xenon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.xenon.entity.Patient;

@Repository
public interface PatientMapper extends BaseMapper<Patient>
{
}
