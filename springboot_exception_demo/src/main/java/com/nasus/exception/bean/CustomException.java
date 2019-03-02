package com.nasus.exception.bean;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.bean <br/>
 * Date:2019/3/2 22:21 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class CustomException extends RuntimeException{

    /**
     * 状态码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CustomException(Integer code, String message){

        super(message);
        this.code = code;

    }
}
