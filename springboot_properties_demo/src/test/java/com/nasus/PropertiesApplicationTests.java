package com.nasus;

import com.nasus.bean.PropertiesBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropertiesApplication.class)
public class PropertiesApplicationTests {


    @Autowired
    private PropertiesBean propertiesBean;


    @Test
    public void getMessage(){
        Assert.assertEquals(propertiesBean.getName(),"一个优秀的废人");
    }

}

