package com.nasus.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Project Name:springboot_websocket_demo <br/>
 * Package Name:com.nasus.websocket.config <br/>
 * Date:2019/3/4 21:47 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Configuration
// @EnableWebSocketMessageBroker 注解用于开启使用 STOMP 协议来传输基于代理（MessageBroker）的消息，这时候控制器(controller)
// 开始支持@MessageMapping,就像是使用 @requestMapping 一样。
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个名为 /endpointNasus 的 Stomp 节点(endpoint),并指定使用 SockJS 协议。
        registry.addEndpoint("/endpointNasus").withSockJS();
        //注册一个名为 /endpointChat 的 Stomp 节点(endpoint),并指定使用 SockJS 协议。
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 广播式配置名为 /nasus 消息代理 , 这个消息代理必须和 controller 中的 @SendTo 配置的地址前缀一样或者全匹配
        // 点对点增加一个 /queue 消息代理
        registry.enableSimpleBroker("/queue","/nasus/getResponse");
    }
}
