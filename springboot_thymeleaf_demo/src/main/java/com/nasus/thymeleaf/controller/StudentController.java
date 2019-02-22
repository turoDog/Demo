package com.nasus.thymeleaf.controller;

import com.nasus.thymeleaf.entity.Student;
import com.nasus.thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Project Name:springboot_thymeleaf_demo <br/>
 * Package Name:com.nasus.thymeleaf.controller <br/>
 * Date:2019/2/22 0022 14:29 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:chenzy@eastcom-sw.com">chenzy</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 获取学生信息列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public String findStudentList(ModelMap map) {
        map.addAttribute("studentList",studentService.findStudentList());
        return "studentList";
    }

    /**
     * 获取保存 student 表单
     */
    @GetMapping(value = "/create")
    public String createStudentForm(ModelMap map) {
        map.addAttribute("student", new Student());
        map.addAttribute("action", "create");
        return "studentForm";
    }

    /**
     * 保存学生信息
     * @param student
     * @return
     */
    @PostMapping(value = "/create")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    /**
     * 根据 id 获取 student 表单，编辑后提交更新
     * @param id
     * @param map
     * @return
     */
    @GetMapping(value = "/update/{id}")
    public String edit(@PathVariable Long id, ModelMap map) {
        map.addAttribute("student", studentService.findStudentById(id));
        map.addAttribute("action", "update");
        return "studentForm";
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PostMapping(value = "/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/list";
    }
}
