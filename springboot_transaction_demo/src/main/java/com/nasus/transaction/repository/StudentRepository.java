package com.nasus.transaction.repository;

import com.nasus.transaction.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project Name:springboot_transaction_demo <br/>
 * Package Name:com.nasus.transaction.repository <br/>
 * Date:2019/2/20 0020 14:17 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
