package com.nasus.service.impl;

import com.nasus.dao.IStudentDao;
import com.nasus.domain.Student;
import com.nasus.service.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Project Name:jdbctemplate_demo <br/>
 * Package Name:com.nasus.service.impl <br/>
 * Date:2019/2/3 11:18 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao iStudentDao;

    @Override
    public int add(Student student) {
        return iStudentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return iStudentDao.update(student);
    }

    @Override
    public int delete(int id) {
        return iStudentDao.delete(id);
    }

    @Override
    public Student findStudentById(int id) {
        return iStudentDao.findStudentById(id);
    }

    @Override
    public List<Student> findStudentList() {
        return iStudentDao.findStudentList();
    }

}
