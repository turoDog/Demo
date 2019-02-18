package com.nasus.mybatis.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project Name:springboot_mybatis_demo <br/>
 * Package Name:com.nasus.mybatis.domain <br/>
 * Date:2019/2/18 0018 14:51 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

}
