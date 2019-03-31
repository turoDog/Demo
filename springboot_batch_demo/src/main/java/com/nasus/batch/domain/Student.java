package com.nasus.batch.domain;

import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Project Name:springboot_batch_demo <br/>
 * Package Name:com.nasus.batch.domain <br/>
 * Date:2019/3/31 15:02 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
public class Student implements Serializable{

    private static final long serialVersionUID = -999048101401385472L;

    private Integer id;

    // 校验名字长度必须在 2-4 之间
    @Size(max = 4, min = 2)
    private String name;

    private Integer age;

    private String gender;

}
