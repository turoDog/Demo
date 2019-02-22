package com.nasus.thymeleaf.repository;

import com.nasus.thymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springboot_thymeleaf_demo <br/>
 * Package Name:com.nasus.thymeleaf.repository <br/>
 * Date:2019/2/22 0022 11:28 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
