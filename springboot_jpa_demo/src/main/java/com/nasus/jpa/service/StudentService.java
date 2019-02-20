package com.nasus.jpa.service;

import com.nasus.jpa.entity.Student;
import java.util.List;

/**
 * Project Name:springboot_jpa_demo <br/>
 * Package Name:com.nasus.jpa.service <br/>
 * Date:2019/2/19 21:41 <br/>
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

    Student findStudentById(Integer id);

    void delete(Integer id);

    void updateStudent(Student student);

    List<Student> findStudentList();

}
