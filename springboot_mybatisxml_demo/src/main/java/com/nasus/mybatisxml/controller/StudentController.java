package com.nasus.mybatisxml.controller;

import com.github.pagehelper.PageInfo;
import com.nasus.mybatisxml.model.Student;
import com.nasus.mybatisxml.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_mybatisxml_demo <br/>
 * Package Name:com.nasus.mybatisxml.controller <br/>
 * Date:2019/2/28 0028 16:17 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
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

    @GetMapping("/{id}")
    public Student findStidentById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }

    @PostMapping("/add")
    public int insertStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/list")
    public PageInfo<Student> findStudentList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        return studentService.findAllStudent(pageNum,pageSize);
    }
}
