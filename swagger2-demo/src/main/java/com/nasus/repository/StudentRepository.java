package com.nasus.repository;

import com.nasus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Project Name:swagger2-demo <br/>
 * Package Name:com.nasus.repository <br/>
 * Date:2019/1/22 22:05 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentRepository extends JpaRepository<Student, Integer>, CrudRepository<Student, Integer> {
}
