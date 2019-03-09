package com.nasus.mongodb.domain;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.domain <br/>
 * Date:2019/3/9 17:13 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
public class Student {

    @Id
    private String id;

    @NotNull
    private String studentId;

    private Integer age;

    private String name;

    private String gender;

}
