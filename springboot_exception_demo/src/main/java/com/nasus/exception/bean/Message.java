package com.nasus.exception.bean;

import java.io.Serializable;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.bean <br/>
 * Date:2019/3/2 21:44 <br/>
 * <b>Description:</b> TODO: 返回信息实体类 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class Message<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回的数据类
     */
    private T data;

    /**
     * 时间
     */
    private Long time;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Message(Integer code, String message, T data, Long time) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.time = time;
    }
}
