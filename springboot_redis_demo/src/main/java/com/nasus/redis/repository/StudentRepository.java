package com.nasus.redis.repository;

import com.nasus.redis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springboot_jpa_demo <br/>
 * Package Name:com.nasus.jpa.repository <br/>
 * Date:2019/2/19 21:37 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>, CrudRepository<Student, Integer> {
}
