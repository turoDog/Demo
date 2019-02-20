package com.nasus.jpa.service.impl;

import com.nasus.jpa.entity.Student;
import com.nasus.jpa.repository.StudentRepository;
import com.nasus.jpa.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_jpa_demo <br/>
 * Package Name:com.nasus.jpa.service.impl <br/>
 * Date:2019/2/19 21:43 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 保存学生信息
     * @param student
     * @return
     */
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * 根据 Id 查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    /**
     * 删除学生信息
     * @param id
     */
    @Override
    public void delete(Integer id) {
        Student student = this.findStudentById(id);
        studentRepository.delete(student);
    }

    /**
     * 更新学生信息
     * @param student
     */
    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    /**
     * 查询学生信息列表
     * @return
     */
    @Override
    public List<Student> findStudentList() {
        return studentRepository.findAll();
    }
}
