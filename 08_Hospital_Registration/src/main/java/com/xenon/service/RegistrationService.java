package com.xenon.service;

import com.xenon.mapper.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xenon.entity.Registration;

import java.util.List;

@Service
public class RegistrationService
{
    @Autowired
    RegistrationMapper registrationMapper;

    public List<Registration> selectRegistrations()
    {
        return registrationMapper.selectList(null);
    }

    public List<Registration> selectAllOfRegistrations()
    {
        return registrationMapper.selectAllOfRegistrations();
    }

    // public List<Teacher> selectTeachersByWrapper(Teacher teacher)
    // {
    //     QueryWrapper<Teacher> wrapper = new QueryWrapper<>();// 构建一个查询的wrapper
    //
    //     Map<String, Object> map = new HashMap<>()
    //     {
    //         {
    //             put("id", teacher.getId());
    //             put("sex", teacher.getSex());
    //             put("age", teacher.getAge());
    //             put("major", teacher.getMajor());
    //         }
    //     };
    //
    //     wrapper
    //             .allEq(map, false)
    //             .like("name", teacher.getName());
    //     return teacherMapper.selectList(wrapper);
    // }

    // @Transactional
    // public int insertTeacher(Teacher teacher)
    // {
    //     return teacherMapper.insert(teacher);
    // }
    //
    // @Transactional
    // public int updateTeacher(Teacher teacher)
    // {
    //     return teacherMapper.updateById(teacher);
    // }
    //
    // @Transactional
    // public int deleteTeacher(Serializable id)
    // {
    //     return teacherMapper.deleteById(id);
    // }

}
