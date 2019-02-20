package com.nasus.transaction.service.impl;

import com.nasus.transaction.domain.Student;
import com.nasus.transaction.repository.StudentRepository;
import com.nasus.transaction.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project Name:springboot_transaction_demo <br/>
 * Package Name:com.nasus.transaction.service.impl <br/>
 * Date:2019/2/20 0020 14:23 <br/>
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
    // 直接注入 StudentRepository 的 bean
    private StudentRepository studentRepository;

    // 使用 @Transactional 注解的 rollbackFor 属性，指定特定异常时，触发回滚
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Student saveStudentWithRollBack(Student student) {
        Student s = studentRepository.save(student);
        if ("高斯林".equals(s.getName())){
            //硬编码，手动触发异常
            throw new IllegalArgumentException("高斯林已存在，数据将回滚");
        }
        return s;
    }

    // 使用 @Transactional 注解的 noRollbackFor 属性，指定特定异常时，不触发回滚
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Student saveStudentWithoutRollBack(Student student) {
        Student s = studentRepository.save(student);
        if ("高斯林".equals(s.getName())){
            throw new IllegalArgumentException("高斯林已存在，数据将不会回滚");
        }
        return s;
    }

}
