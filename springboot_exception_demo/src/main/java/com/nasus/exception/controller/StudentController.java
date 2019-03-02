package com.nasus.exception.controller;

import com.nasus.exception.bean.CustomException;
import com.nasus.exception.bean.Message;
import com.nasus.exception.bean.Student;
import com.nasus.exception.service.StudentService;
import com.nasus.exception.util.MessageUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.controller <br/>
 * Date:2019/3/2 22:42 <br/>
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

    @GetMapping("/{id}")
    public Message<Student> findStudentById(@PathVariable("id") Integer id){

        if (id < 0){
            //测试自定义错误
            throw new CustomException(110, "参数不能是负数！");

        } else if (id == 0){
            //硬编码，为了测试
            Integer i = 1/id;
            return null;
        } else {
            Student student = studentService.findStudentById(id);
            return MessageUtil.ok(student);
        }

    }

}
