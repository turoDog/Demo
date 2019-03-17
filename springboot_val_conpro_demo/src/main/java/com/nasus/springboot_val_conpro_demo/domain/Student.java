package com.nasus.springboot_val_conpro_demo.domain;

import java.util.List;
import java.util.Map;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Project Name:springboot_val_conpro_demo <br/>
 * Package Name:com.nasus.springboot_val_conpro_demo.domain <br/>
 * Date:2019/3/17 17:17 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Component
//@Validated
//@ConfigurationProperties(prefix = "student") // 指定配置文件中的 student 属性与这个 bean绑定
public class Student {

    /**
     * <bean class="Student">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * <bean/>
     */

    //@Value("陈") // 字面量
    //@Value("${student.first-name}")
    //@Length(min=5, max=20, message="用户名长度必须在5-20之间")
    private String firstName;

    //@Value("${student.lastName}") // 从环境变量、配置文件中获取值
    private String lastName;

    //@Value("#{12*2}") // #{SpEL}
    private Integer age;

    private String gender;

    private String city;

    @Value("${student.teacher}")
    private Teacher teacher;

    private List<String> hobbys;

    @Value("${student.scores}")
    private Map<String,Integer> scores;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", teacher=" + teacher +
                ", hobbys=" + hobbys +
                ", scores=" + scores +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }
}
