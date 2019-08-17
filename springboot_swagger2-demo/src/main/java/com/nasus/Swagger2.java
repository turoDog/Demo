package com.nasus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Project Name:swagger2-demo <br/>
 * Package Name:com.nasus <br/>
 * Date:2019/1/22 22:52 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Configuration
// 启用 Swagger2
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 文档信息对象
                .apiInfo(apiInfo())
                .select()
                // 被注解的包路径
                .apis(RequestHandlerSelectors.basePackage("com.nasus.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("springboot 利用 swagger 构建 API 文档")
                // Api 文档描述
                .description("简单优雅的 restful 风格，https://blog.csdn.net/turodog/")

                .termsOfServiceUrl("https://blog.csdn.net/turodog/")
                // 文档作者信息
                .contact(new Contact("陈志远", "https://github.com/turoDog", "turodog@foxmail.com"))
                // 文档版本
                .version("1.0")
                .build();
    }
}
