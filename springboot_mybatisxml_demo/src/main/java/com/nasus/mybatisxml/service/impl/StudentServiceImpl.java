package com.nasus.mybatisxml.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasus.mybatisxml.mapper.StudentMapper;
import com.nasus.mybatisxml.model.Student;
import com.nasus.mybatisxml.service.StudentService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_mybatisxml_demo <br/>
 * Package Name:com.nasus.mybatisxml.service.impl <br/>
 * Date:2019/2/28 0028 16:04 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Service
public class StudentServiceImpl implements StudentService{

    //会报错，不影响
    @Resource
    private StudentMapper studentMapper;

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    /**
     * 根据 id 查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有学生信息并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Student> findAllStudent(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentMapper.selectStudents();
        PageInfo result = new PageInfo(studentList);
        return result;
    }

}
