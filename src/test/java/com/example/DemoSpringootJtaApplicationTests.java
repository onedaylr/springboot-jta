package com.example;

import com.example.entity.car.MessagePackageNo;
import com.example.entity.test.User;
import com.example.mapper.car.MessagePackageNoMapper;
import com.example.mapper.test.UserMapper;
import com.example.service.car.MessagePackageNoService;
import com.example.service.group.IndexService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringootJtaApplication.class)
public class DemoSpringootJtaApplicationTests {
    @Autowired
    private IndexService  indexService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessagePackageNoMapper messagePackageNoMapper;

    @Test
    public void contextLoads() {
        // 构造数据
        MessagePackageNo messagePackageNo = new MessagePackageNo();
        messagePackageNo.setNo(99);
        messagePackageNo.setCreateTime(new Date());

        User user = new User();
        user.setAge(25);
        user.setName("example");
        user.setCreateTime(new Date());
        indexService.save(messagePackageNo , user , 1);

      User newUser =  userMapper.findByName(user.getName());
      Assert.assertEquals(newUser.getAge(),user.getAge() );

        MessagePackageNo newNo = messagePackageNoMapper.findByno(messagePackageNo.getNo());
        Assert.assertEquals(messagePackageNo.getNo(),newNo.getNo() );

    }

    @Test
    public void contextLoadsError() {
        // 构造数据
        MessagePackageNo messagePackageNo = new MessagePackageNo();
        messagePackageNo.setNo(100);
        messagePackageNo.setCreateTime(new Date());

        User user = new User();
        user.setAge(30);
        user.setName("example_error");
        user.setCreateTime(new Date());
        try {
        indexService.save(messagePackageNo , user , 0);
        }catch (Exception e){
            Assert.assertEquals(ArithmeticException.class.getName() , e.getClass().getName());
        }

        User newUser =  userMapper.findByName(user.getName());
        Assert.assertEquals(null,newUser );

        MessagePackageNo newNo = messagePackageNoMapper.findByno(messagePackageNo.getNo());
        Assert.assertEquals(null,newNo);


    }

}
