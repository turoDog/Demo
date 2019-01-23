package com.nasus.controller;

import com.nasus.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_lomnok_demo <br/>
 * Package Name:com.nasus.controller <br/>
 * Date:2019/1/23 0023 14:37 <br/>
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

    @GetMapping("/testLombok")
    public Student getStudent(){
        Student student = new Student();
        student.setId("6666666666");
        student.setAge(24);
        student.setName("陈志远");
        System.out.println(student.toString());
        return student;
    }

}
