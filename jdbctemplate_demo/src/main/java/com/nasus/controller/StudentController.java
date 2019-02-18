package com.nasus.controller;

import com.nasus.domain.Student;
import com.nasus.service.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:jdbctemplate_demo <br/>
 * Package Name:com.nasus.controller <br/>
 * Date:2019/2/3 11:21 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping("")
    public int addStudent(@RequestBody Student student){
        return iStudentService.add(student);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student){
        Student oldStudent = new Student();
        oldStudent.setId(id);
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        int t = iStudentService.update(oldStudent);
        if (t == 1){
            return student.toString();
        }else {
            return "更新学生信息错误";
        }
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable Integer id){
        return iStudentService.findStudentById(id);
    }

    @GetMapping("/list")
    public List<Student> findStudentList(){
        return iStudentService.findStudentList();
    }

    @DeleteMapping("/{id}")
    public int deleteStudentById(@PathVariable Integer id){
        return iStudentService.delete(id);
    }
}
