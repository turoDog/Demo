package com.nasus.transaction.controller.StudentController;

import com.nasus.transaction.domain.Student;
import com.nasus.transaction.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_transaction_demo <br/>
 * Package Name:com.nasus.transaction.controller.StudentController <br/>
 * Date:2019/2/20 0020 14:42 <br/>
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

    // 注入 studentservice 的 bean
    @Autowired
    private StudentService studentService;

    // 测试回滚情况
    @PostMapping("/withRollBack")
    public Student saveStudentWithRollBack(@RequestBody Student student){
        return studentService.saveStudentWithRollBack(student);
    }

    // 测试不回滚情况
    @PostMapping("/withOutRollBack")
    public Student saveStudentWithoutRollBack(@RequestBody Student student){
        return studentService.saveStudentWithoutRollBack(student);
    }
}
