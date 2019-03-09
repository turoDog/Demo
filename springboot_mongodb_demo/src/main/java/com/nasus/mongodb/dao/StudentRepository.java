package com.nasus.mongodb.dao;

import com.nasus.mongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.dao <br/>
 * Date:2019/3/9 17:17 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
