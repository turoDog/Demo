package com.nasus.exception.handler;

import com.nasus.exception.bean.CustomException;
import com.nasus.exception.bean.Message;
import com.nasus.exception.util.MessageUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.handler <br/>
 * Date:2019/3/2 22:29 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public <E>Message<E> handler(Exception exception){

        if (exception instanceof CustomException){
            CustomException customException = (CustomException) exception;
            return MessageUtil.error(customException.getCode(), customException.getMessage());
        } else {
            return MessageUtil.error(120, "异常信息：" + exception.getMessage());
        }
    }
}
