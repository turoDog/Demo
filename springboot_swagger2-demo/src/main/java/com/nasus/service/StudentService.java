package com.nasus.service;

import com.nasus.entity.Student;
import java.util.List;

/**
 * Project Name:swagger2-demo <br/>
 * Package Name:com.nasus.service <br/>
 * Date:2019/1/22 22:09 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    Student save(Student student);

    Student findById(Integer id);

    void delete(Integer id);

    List<Student> findAll();
}
