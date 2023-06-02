package com.xenon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.xenon.entity.Doctor;
import com.xenon.entity.Patient;
import com.xenon.entity.Registration;

import java.util.List;

@Repository
public interface RegistrationMapper extends BaseMapper<Registration>
{
    @Select("SELECT * FROM registration")
    @Results
            (
                {
                    @Result(column = "id", property = "id"),
                    @Result(column = "patient_id", property = "patientId"),
                    @Result(column = "doctor_id", property = "doctorId"),
                    @Result(column = "department", property = "department"),
                    @Result(column = "registration_time", property = "registrationTime"),

                    @Result(column = "patient_id", property = "patient", javaType = Patient.class,
                            one = @One(select = "com.xenon.mapper.PatientMapper.selectById")),
                    @Result(column = "doctor_id", property = "doctor", javaType = Doctor.class,
                            one = @One(select = "com.xenon.mapper.DoctorMapper.selectById")),
                }
            )
    List<Registration> selectAllOfRegistrations();
}
