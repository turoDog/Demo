package com.nasus.websocket.domain;

/**
 * Project Name:springboot_websocket_demo <br/>
 * Package Name:com.nasus.websocket.domain <br/>
 * Date:2019/3/4 22:14 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 * 服务器向浏览器发送消息用这个类
 */
public class Server2ClientMessage {

    private String responseMessage;

    public Server2ClientMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
