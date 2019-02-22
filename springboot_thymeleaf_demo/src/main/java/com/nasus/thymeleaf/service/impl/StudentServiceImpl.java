package com.nasus.thymeleaf.service.impl;

import com.nasus.thymeleaf.entity.Student;
import com.nasus.thymeleaf.repository.StudentRepository;
import com.nasus.thymeleaf.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_thymeleaf_demo <br/>
 * Package Name:com.nasus.thymeleaf.service.impl <br/>
 * Date:2019/2/22 0022 11:34 <br/>
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
    private StudentRepository studentRepository;

    /**
     * 查询所有学生信息列表
     * @return
     */
    @Override
    public List<Student> findStudentList() {
        Sort sort = new Sort(Direction.ASC,"id");
        return studentRepository.findAll(sort);
    }

    /**
     * 根据 id 查询单个学生信息
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    /**
     * 保存学生信息
     * @param student
     * @return
     */
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * 根据 id 删除学生信息
     * @param id
     * @return
     */
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
