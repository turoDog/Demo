package com.nasus.entity;

import java.util.Objects;

/**
 * Project Name:springboot_lomnok_demo <br/>
 * Package Name:com.nasus.entity <br/>
 * Date:2019/1/23 0023 14:34 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class StudentNoLombok {

    private String id;
    private String name;
    private int age;

    public StudentNoLombok() {
    }

    public StudentNoLombok(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StudentNoLombok)) {
            return false;
        }
        StudentNoLombok that = (StudentNoLombok) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "StudentNoLombok{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
