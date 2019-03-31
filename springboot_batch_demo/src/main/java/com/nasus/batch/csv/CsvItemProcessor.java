package com.nasus.batch.csv;

import com.nasus.batch.domain.Student;
import javax.xml.bind.ValidationException;
import org.springframework.batch.item.validator.ValidatingItemProcessor;

/**
 * Project Name:springboot_batch_demo <br/>
 * Package Name:com.nasus.batch.csv <br/>
 * Date:2019/3/31 15:30 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
// 数据处理
public class CsvItemProcessor extends ValidatingItemProcessor<Student> {

    @Override
    public Student process(Student item) {
        // 调用自定义校验器
        super.process(item);

        // 做简单的数据处理
        if ("男".equals(item.getGender())){
            item.setGender("左");
        }else {
            item.setGender("右");
        }
        return item;
    }
}
