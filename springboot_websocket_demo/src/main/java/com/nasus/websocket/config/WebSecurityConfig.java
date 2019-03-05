package com.nasus.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Project Name:websocket <br/>
 * Package Name:com.nasus.websocket.config <br/>
 * Date:2019/3/5 0005 16:23 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             // 设置 SpringSecurity 对 / 和 "/login" 路径不拦截
            .mvcMatchers("/","/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            // 设置 Spring Security 的登录页面访问路径为/login
            .loginPage("/login")
            // 登录成功后转向 /chat 路径
            .defaultSuccessUrl("/chat")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            // 再内存中分配两个用户 nasus 和 chenzy ，用户名和密码一致
            .withUser("nasus").password("nasus").roles("USER")
            .and()
            .withUser("chenzy").password("chenzy").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // /resource/static 目录下的静态资源，Spring Security 不拦截
        web.ignoring().antMatchers("/resource/static**");
    }
}
