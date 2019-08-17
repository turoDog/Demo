package com.nasus.dao.impl;

import com.nasus.dao.IStudentDao;
import com.nasus.domain.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Project Name:jdbctemplate_demo <br/>
 * Package Name:com.nasus.dao.impl <br/>
 * Date:2019/2/3 11:00 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 */
@Repository
public class IStudentDaoImpl implements IStudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        return jdbcTemplate.update("insert into student(name, age) values(?, ?)",
                student.getName(),student.getAge());
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update("UPDATE  student SET NAME=? ,age=? WHERE id=?",
                student.getName(),student.getAge(),student.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE student where id=?",id);
    }

    @Override
    public Student findStudentById(int id) {
        // BeanPropertyRowMapper 使获取的 List 结果列表的数据库字段和实体类自动对应
        List<Student> list = jdbcTemplate.query("select * from student where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Student.class));
        if(list!=null && list.size()>0){
            Student student = list.get(0);
            return student;
        }else{
            return null;
        }
    }

    @Override
    public List<Student> findStudentList() {
        // 使用Spring的JdbcTemplate查询数据库，获取List结果列表，数据库表字段和实体类自动对应，可以使用BeanPropertyRowMapper
        List<Student> list = jdbcTemplate.query("select * from student", new Object[]{}, new BeanPropertyRowMapper(Student.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}
