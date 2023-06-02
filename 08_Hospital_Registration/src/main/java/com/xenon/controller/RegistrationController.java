package com.xenon.controller;

import com.xenon.service.RegistrationService;
import com.xenon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xenon.entity.Registration;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/registration")
public class RegistrationController
{
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/all")
    public Result getAllOfRegistrations()
    {
        List<Registration> registrations = registrationService.selectAllOfRegistrations();
        return Result.pass().data("data", registrations);
    }



    // @GetMapping("/query")
    // public Result getTeachersBy(Teacher teacher)
    // {
    //     List<Teacher> teachers = teacherService.selectTeachersByWrapper(teacher);
    //     return Result.pass().data("data", teachers);
    // }

    //
    // @PostMapping("/insert")
    // public Result insert(@RequestBody Teacher teacher)
    // {
    //     int num = teacherService.insertTeacher(teacher);
    //     return Result.pass().data("data", num);
    // }
    //
    // @PutMapping("/update")
    // public Result update(@RequestBody Teacher teacher)
    // {
    //     int num = teacherService.updateTeacher(teacher);
    //     return Result.pass().data("data", num);
    // }
    //
    // @DeleteMapping("/delete/{id}")
    // public Result delete(@PathVariable Serializable id)
    // {
    //     int num = teacherService.deleteTeacher(id);
    //     return Result.pass().data("data", num);
    // }

}
