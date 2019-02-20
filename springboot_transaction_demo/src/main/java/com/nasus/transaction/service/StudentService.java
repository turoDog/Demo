package com.nasus.transaction.service;

import com.nasus.transaction.domain.Student;

/**
 * Project Name:springboot_transaction_demo <br/>
 * Package Name:com.nasus.transaction.service <br/>
 * Date:2019/2/20 0020 14:21 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    Student saveStudentWithRollBack(Student student);

    Student saveStudentWithoutRollBack(Student student);

}
