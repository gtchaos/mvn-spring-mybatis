package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;


@Service("userServiceBean")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public int insertUser(User user) {
        // TODO Auto-generated method stub
        System.out.println("hello world");
        return userDAO.insertUser(user);
    }

    public User getUser(int id) {
        // TODO Auto-generated method stub
        return userDAO.findById(id);
    }
}