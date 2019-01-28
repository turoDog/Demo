package com.nasus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project Name:springboot_lomnok_demo <br/>
 * Package Name:com.nasus.entity <br/>
 * Date:2019/1/23 0023 14:32 <br/>
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

    private String id;
    private String name;
    private int age;

}
