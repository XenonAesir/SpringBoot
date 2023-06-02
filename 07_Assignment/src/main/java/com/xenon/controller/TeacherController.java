package com.xenon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xenon.entity.Teacher;
import com.xenon.mapper.TeacherMapper;
import com.xenon.service.TeacherService;
import com.xenon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController
{
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherMapper teacherMapper;

    @GetMapping("/all")
    public Result getAllTeachers()
    {
        List<Teacher> teachers = teacherService.selectTeachers();
        return Result.pass().data("data", teachers);
    }

    @GetMapping("/query")
    public Result getTeachersBy(Teacher teacher)
    {
        List<Teacher> teachers = teacherService.selectTeachersByWrapper(teacher);
        return Result.pass().data("data", teachers);
    }

    @GetMapping("/ipage")
    public Result page(@RequestParam(value = "page") int current)
    {
        System.out.println(current);
        IPage<Teacher> ipage = teacherService.findByPage(current, 15, null);
        return Result.pass().data("data", ipage);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Teacher teacher)
    {
        int num = teacherService.insertTeacher(teacher);
        return Result.pass().data("data", num);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Teacher teacher)
    {
        int num = teacherService.updateTeacher(teacher);
        return Result.pass().data("data", num);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Serializable id)
    {
        int num = teacherService.deleteTeacher(id);
        return Result.pass().data("data", num);
    }

}
