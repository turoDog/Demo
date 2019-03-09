package com.nasus.mongodb.controller;

import com.nasus.mongodb.domain.Student;
import com.nasus.mongodb.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.controller <br/>
 * Date:2019/3/9 17:43 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") String id){
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") String id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/list")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

}
