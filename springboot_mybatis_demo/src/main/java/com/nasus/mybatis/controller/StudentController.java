package com.nasus.mybatis.controller;

import com.nasus.mybatis.domain.Student;
import com.nasus.mybatis.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_mybatis_demo <br/>
 * Package Name:com.nasus.mybatis.controller <br/>
 * Date:2019/2/18 0018 15:16 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public int add(@RequestBody Student student){
        return studentService.add(student);
    }

    @PutMapping("/{id}")
    public int updateStudent(@PathVariable("id") Integer id, @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) Integer age){
        return studentService.update(name,age,id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.delete(id);
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") Integer id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/list")
    public List<Student> findStudentList(){
        return studentService.findStudentList();
    }
}
