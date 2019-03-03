package com.nasus.validateone.controller;

import com.nasus.validateone.bean.Student;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_validateone_demo <br/>
 * Package Name:com.nasus.validateone.controller <br/>
 * Date:2019/3/3 17:08 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Validated //开启数据校验，添加在类上用于校验方法，添加在方法参数中用于校验参数对象。(添加在方法上无效)
@RestController
@RequestMapping("/student")
public class ValidateOneController {

    /**
     * 普通参数校验
     * @param name
     * @return
     */
    @GetMapping("/name")
    public String findStudentByName(@NotBlank(message = "学生名字不能为空")
    @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间")String name){
        return "success";
    }

    /**
     * 对象校验
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String addStudent(@Validated @RequestBody Student student){
        return "success";
    }

}
