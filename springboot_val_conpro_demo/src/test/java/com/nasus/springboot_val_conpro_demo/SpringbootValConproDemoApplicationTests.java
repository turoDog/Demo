package com.nasus.springboot_val_conpro_demo;

import com.nasus.springboot_val_conpro_demo.domain.Student;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootValConproDemoApplicationTests {

    @Autowired
    private Student student;

    @Test
    public void contextLoads() {
        // 这里为了方便，但工作中千万不能用 System.out
        System.out.println(student.toString());
    }

}
