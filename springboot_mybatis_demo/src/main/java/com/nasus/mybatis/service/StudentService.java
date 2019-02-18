package com.nasus.mybatis.service;

import com.nasus.mybatis.domain.Student;
import java.util.List;

/**
 * Project Name:springboot_mybatis_demo <br/>
 * Package Name:com.nasus.mybatis.service <br/>
 * Date:2019/2/18 0018 15:07 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    int add(Student student);

    int update(String name, Integer age, Integer id);

    int delete(Integer id);

    Student findStudentById(Integer id);

    List<Student> findStudentList();

}
