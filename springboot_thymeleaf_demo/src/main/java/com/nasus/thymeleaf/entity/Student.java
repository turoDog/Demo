package com.nasus.thymeleaf.entity;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project Name:springboot_thymeleaf_demo <br/>
 * Package Name:com.nasus.thymeleaf.entity <br/>
 * Date:2019/2/22 0022 15:37 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
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

    @Id
    @GeneratedValue
    /**
     * 主键
     */
    private Long id;

    /**
     * 主键
     */
    private Long studentId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 专业
     */
    private String major;

    /**
     * 宿舍
     */
    private String dormitory;

    /**
     * 籍贯
     */
    private String city;

}
