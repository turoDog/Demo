package com.nasus.mongodb.service.impl;

import com.nasus.mongodb.dao.StudentRepository;
import com.nasus.mongodb.domain.Student;
import com.nasus.mongodb.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.service.impl <br/>
 * Date:2019/3/9 17:23 <br/>
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
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * 根据 id 删除学生信息
     * @param id
     */
    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student updateStudent(Student student) {
        Student oldStudent = this.findStudentById(student.getId());
        if (oldStudent != null){
            oldStudent.setStudentId(student.getStudentId());
            oldStudent.setAge(student.getAge());
            oldStudent.setName(student.getName());
            oldStudent.setGender(student.getGender());
            return studentRepository.save(oldStudent);
        } else {
            return null;
        }
    }

    /**
     * 根据 id 查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    /**
     * 查询学生信息列表
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
