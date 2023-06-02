package com.xenon.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xenon.entity.Teacher;
import com.xenon.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService
{
    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> selectTeachers()
    {
        return teacherMapper.selectList(null);
    }

    public List<Teacher> selectTeachersByWrapper(Teacher teacher)
    {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();// 构建一个查询的wrapper

        Map<String, Object> map = new HashMap<>()
        {
            {
                put("id", teacher.getId());
                put("sex", teacher.getSex());
                put("age", teacher.getAge());
                put("major", teacher.getMajor());
            }
        };

        wrapper
                .allEq(map, false)
                .like("name", teacher.getName());
        return teacherMapper.selectList(wrapper);
    }

    @Transactional
    public int insertTeacher(Teacher teacher)
    {
        return teacherMapper.insert(teacher);
    }

    @Transactional
    public int updateTeacher(Teacher teacher)
    {
        return teacherMapper.updateById(teacher);
    }

    @Transactional
    public int deleteTeacher(Serializable id)
    {
        return teacherMapper.deleteById(id);
    }

    // 分页查询
    public IPage<Teacher> findByPage(int current, int size, QueryWrapper<Teacher> queryWrapper)
    {
        // Page为一个范围，表示当前的位置和一页的量
        Page<Teacher> teacherPage = new Page<>(current, size);
        // IPage是分页后的结果，包含有许多参数返回给前端
        IPage<Teacher> iPage = teacherMapper.selectPage(teacherPage, queryWrapper);
        return iPage;
    }

}
