package com.nasus.batch.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Project Name:springboot_batch_demo <br/>
 * Package Name:com.nasus.batch.csv <br/>
 * Date:2019/3/31 15:48 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class CsvJobListener implements JobExecutionListener {

    private Logger logger = LoggerFactory.getLogger(CsvJobListener.class);

    private long startTime;
    private long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        logger.info("任务处理开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        logger.info("任务处理结束");
        logger.info("任务耗时：" + (endTime-startTime) + "ms");
    }
}
