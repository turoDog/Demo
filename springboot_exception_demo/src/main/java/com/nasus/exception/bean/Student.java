package com.nasus.exception.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.bean <br/>
 * Date:2019/3/2 21:49 <br/>
 * <b>Description:</b> TODO: 学生类 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
@Entity
public class Student {

    // 自增 id
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

}
