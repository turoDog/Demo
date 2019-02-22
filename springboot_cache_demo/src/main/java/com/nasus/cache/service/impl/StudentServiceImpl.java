package com.nasus.cache.service.impl;

import com.nasus.cache.entity.Student;
import com.nasus.cache.repository.StudentRepository;
import com.nasus.cache.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_cache_demo <br/>
 * Package Name:com.nasus.cache.service.impl <br/>
 * Date:2019/2/20 0020 17:12 <br/>
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

    // 使用 slf4j 作为日志框架
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @CachePut(value = "student",key = "#student.id")
    // @CachePut 缓存新增的或更新的数据到缓存，其中缓存名称为 student 数据的 key 是 student 的 id
    public Student saveStudent(Student student) {
        Student s = studentRepository.save(student);
        LOGGER.info("为id、key 为{}的数据做了缓存", s.getId());
        return s;
    }

    @Override
    @CacheEvict(value = "student")
    // @CacheEvict 从缓存 student 中删除 key 为 id 的数据
    public void deleteStudentById(Integer id) {
        LOGGER.info("删除了id、key 为{}的数据缓存", id);
        //studentRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "student",key = "#id")
    // @Cacheable 缓存 key 为 id 的数据到缓存 student 中
    public Student findStudentById(Integer id) {
        Student s = studentRepository.findById(id).get();
        LOGGER.info("为id、key 为{}的数据做了缓存", id);
        return  s;
    }
}
