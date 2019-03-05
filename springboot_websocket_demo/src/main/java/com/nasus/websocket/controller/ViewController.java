package com.nasus.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Project Name:springboot_websocket_demo <br/>
 * Package Name:com.nasus.websocket.controller <br/>
 * Date:2019/3/4 22:39 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Controller
public class ViewController {

    @GetMapping("/nasus")
    public String getView(){
        return "nasus";
    }

    @GetMapping("/login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("/chat")
    public String getChatView(){
        return "chat";
    }

}
