package com.nasus.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project Name:springboot_jpa_demo <br/>
 * Package Name:com.nasus.jpa.entity <br/>
 * Date:2019/2/19 21:35 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    // test gitmoji
    // 自增 id
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

}
