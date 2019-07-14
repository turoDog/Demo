package com.nasus.redis;

import com.alibaba.fastjson.JSON;
import com.nasus.redis.entity.Student;
import com.nasus.redis.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisApplicationTests {

    @Autowired
    StudentService studentService;

    @Autowired
    RedisTemplate redisTemplate;

    private final static String USERKEY = "username";
    private final static String AGEKEY = "age";
    private final static String CITYKEY = "city";

    private final static String LISTKEY = "studentList";
    private final static String SETKEY = "usernameSet";
    private final static String HASHKEY = "studentHash";

    /**
     * 添加字符串
     */
    @Test
    public void setString(){
        redisTemplate.opsForValue().set(USERKEY,"nasus");
        redisTemplate.opsForValue().set(AGEKEY,24);
        redisTemplate.opsForValue().set(CITYKEY,"清远");
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString(){
        String username = (String) redisTemplate.opsForValue().get(USERKEY);
        int age = (Integer) redisTemplate.opsForValue().get(AGEKEY);
        String city = (String) redisTemplate.opsForValue().get(CITYKEY);
        log.info("姓名{}，年龄{}，所在地{}", username, age, city);
    }

    /**
     * 删除字符串
     */
    @Test
    public void delString(){
        if (redisTemplate.hasKey(USERKEY)){
            redisTemplate.delete("username");
        }else {
            log.error("key {} 不存在", USERKEY);
        }
    }

    /**
     * 添加、获取LIST
     */
    @Test
    public void setList(){
        List<Student> students = studentService.findStudentList();
        log.info("students size = {}", students.size());
        //循环向 studentList 左添加值
        students.forEach(value->redisTemplate.opsForList().leftPush(LISTKEY,value));
        //向 studentList 右添加值
        Student student = new Student();
        student.setId(10);
        student.setAge(24);
        student.setName("rightPush");
        redisTemplate.opsForList().rightPush(LISTKEY,student);
        // 获取值
        log.info("studentList->{}",redisTemplate.opsForList().range(LISTKEY,0,10));
    }

    /**
     * 添加和获取Set
     */
    @Test
    public void setAndGetSet(){
        List<String> usernameList = new ArrayList<>();
        usernameList.add("nasus");
        usernameList.add("nasus");
        usernameList.add("一个优秀的废人");
        //循环向添加值
        usernameList.forEach(value->redisTemplate.opsForSet().add(SETKEY,value));
        log.info("取出usernameSet->{}",redisTemplate.opsForSet().members(SETKEY));
    }

    /**
     * 删除 Set
     */
    @Test
    public void delSet(){
        redisTemplate.opsForSet().remove(SETKEY,"nasus");
    }

    /**
     * 添加 hash
     */
    @Test
    public void setHash(){
        List<Student> students = studentService.findStudentList();
        //添加
        for (Student student : students){
            redisTemplate.opsForHash().put(HASHKEY, student.getId().toString(), student);
        }
    }

    /**
     * 删除 hash
     */
    @Test
    public void delHash(){
        Student student = studentService.findStudentById(0);
        // 删除
        redisTemplate.opsForHash().delete(HASHKEY,JSON.toJSONString(student));
    }

    /**
     * 获取 Hash
     */
    @Test
    public void getHash(){
        List<Student> students = redisTemplate.opsForHash().values(HASHKEY);
        log.info("values = {}", students);
    }

}
