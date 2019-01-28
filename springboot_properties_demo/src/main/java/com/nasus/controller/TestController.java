package com.nasus.controller;

import com.nasus.bean.PropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springboot_properties_demo <br/>
 * Package Name:com.nasus.controller <br/>
 * Date:2019/1/28 21:41 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PropertiesBean propertiesBean;

    @GetMapping("/getInfo")
    public PropertiesBean getInfo(){
        return propertiesBean;
    }

}
