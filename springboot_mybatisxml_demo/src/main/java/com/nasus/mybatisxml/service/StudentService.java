package com.nasus.mybatisxml.service;

import com.github.pagehelper.PageInfo;
import com.nasus.mybatisxml.model.Student;

/**
 * Project Name:springboot_mybatisxml_demo <br/>
 * Package Name:com.nasus.mybatisxml.service <br/>
 * Date:2019/2/28 0028 16:03 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    int addStudent(Student student);

    Student findStudentById(Long id);

    PageInfo<Student> findAllStudent(int pageNum, int pageSize);

}
