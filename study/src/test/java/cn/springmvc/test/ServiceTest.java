package cn.springmvc.test;

import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

public class ServiceTest {

    private UserService userService;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceBean");
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setAge(34);
        user.setName("Allen");
        user.setNickname("开天辟地");
        user.setState(1);
        System.out.println(userService.insertUser(user));
    }

    @Test
    public void getUser(){
        int id = 5;
        System.out.println(userService.getUser(id).getName());
    }
}
