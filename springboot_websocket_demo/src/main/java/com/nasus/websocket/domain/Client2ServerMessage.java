package com.nasus.websocket.domain;

/**
 * Project Name:springboot_websocket_demo <br/>
 * Package Name:com.nasus.websocket.domain <br/>
 * Date:2019/3/4 22:12 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 * 浏览器向服务器发送消息用这个类
 */
public class Client2ServerMessage {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
