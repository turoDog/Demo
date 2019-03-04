package com.nasus.websocket.controller;

import com.nasus.websocket.domain.Client2ServerMessage;
import com.nasus.websocket.domain.Server2ClientMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_websocket_demo <br/>
 * Package Name:com.nasus.websocket.controller <br/>
 * Date:2019/3/4 22:16 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestController
public class WebSocketController {

    @MessageMapping("/hello") // @MessageMapping 和 @RequestMapping 功能类似，浏览器向服务器发起请求时，映射到该地址。
    @SendTo("/nasus/getResponse") //如果服务器接受到了消息，就会对订阅了 @SendTo 括号中的地址的浏览器发送消息。
    public Server2ClientMessage say(Client2ServerMessage message) throws Exception {
        Thread.sleep(3000);
        return new Server2ClientMessage("Hello," + message.getName() + "!");
    }

}
