package com.nasus.dao;

import com.nasus.domain.Student;
import java.util.List;

/**
 * Project Name:jdbctemplate_demo <br/>
 * Package Name:com.nasus.dao <br/>
 * Date:2019/2/3 10:59 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface IStudentDao {

    int add(Student student);

    int update(Student student);

    int delete(int id);

    Student findStudentById(int id);

    List<Student> findStudentList();

}
