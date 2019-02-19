package com.nasus.mybatis.dao;

import com.nasus.mybatis.domain.Student;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Project Name:springboot_mybatis_demo <br/>
 * Package Name:com.nasus.mybatis.dao <br/>
 * Date:2019/2/18 0018 14:57 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Mapper
public interface StudentMapper {

    @Insert("insert into student(name, age) values(#{name}, #{age})")
    int add(Student student);

    @Update("update student set name = #{name}, age = #{age} where id = #{id}")
    int update(@Param("name") String name, @Param("age") Integer age, @Param("id") Integer id);

    @Delete("delete from student where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, age as age from student where id = #{id}")
    Student findStudentById(@Param("id") Integer id);

    @Select("select id, name as name, age as age from student")
    List<Student> findStudentList();
}
