package com.nasus.exception.util;

import com.nasus.exception.bean.Message;
import java.util.Date;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:com.nasus.exception.util <br/>
 * Date:2019/3/2 21:52 <br/>
 * <b>Description:</b> TODO: 返回信息处理工具类 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class MessageUtil {

    /**
     * 成功并返回数据实体类
     * @param o
     * @param <E>
     * @return
     */
    public static <E>Message<E> ok(E o){
        return new Message<>(200, "success", o, new Date().getTime());
    }

    /**
     * 成功，但无数据实体类返回
     * @return
     */
    public static <E>Message<E> ok(){
        return new Message<>(200, "success", null, new Date().getTime());
    }

    /**
     * 失败，有自定义异常返回
     * @param code
     * @param msg
     * @return
     */
    public static <E>Message<E> error(Integer code,String msg){
        return new Message<>(code, msg, null, new Date().getTime());
    }

}
