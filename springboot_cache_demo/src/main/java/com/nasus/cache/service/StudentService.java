package com.nasus.cache.service;

import com.nasus.cache.entity.Student;

/**
 * Project Name:springboot_cache_demo <br/>
 * Package Name:com.nasus.cache.service <br/>
 * Date:2019/2/20 0020 17:03 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    public Student saveStudent(Student student);

    public void deleteStudentById(Integer id);

    public Student findStudentById(Integer id);

}
