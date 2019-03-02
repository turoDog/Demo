package com.nasus.exception.dao;

import com.nasus.exception.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.dao <br/>
 * Date:2019/3/2 22:08 <br/>
 * <b>Description:</b> TODO: 数据访问类 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
