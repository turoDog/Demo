package com.nasus.thymeleaf.service;

import com.nasus.thymeleaf.entity.Student;
import java.util.List;

/**
 * Project Name:springboot_thymeleaf_demo <br/>
 * Package Name:com.nasus.thymeleaf.service <br/>
 * Date:2019/2/22 0022 11:33 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    List<Student> findStudentList();

    Student findStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

}
