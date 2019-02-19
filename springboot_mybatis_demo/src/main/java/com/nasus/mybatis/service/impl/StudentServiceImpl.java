package com.nasus.mybatis.service.impl;

import com.nasus.mybatis.dao.StudentMapper;
import com.nasus.mybatis.domain.Student;
import com.nasus.mybatis.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_mybatis_demo <br/>
 * Package Name:com.nasus.mybatis.service <br/>
 * Date:2019/2/18 0018 15:10 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加 Student
     * @param name
     * @param age
     * @return
     */
    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    /**
     * 更新 Student
     * @param name
     * @param age
     * @param id
     * @return
     */
    @Override
    public int update(String name, Integer age, Integer id) {
        return studentMapper.update(name,age,id);
    }

    /**
     * 删除 Student
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return studentMapper.delete(id);
    }

    /**
     * 根据 id 查询 Student
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(Integer id) {
        return studentMapper.findStudentById(id);
    }

    /**
     * 查询所有的 Student
     * @return
     */
    @Override
    public List<Student> findStudentList() {
        return studentMapper.findStudentList();
    }
}
