package com.nasus.exception.service;

import com.nasus.exception.bean.Student;
import java.util.List;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.service <br/>
 * Date:2019/3/2 22:10 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    Student findStudentById(Integer id);

}
