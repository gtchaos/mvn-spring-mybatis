package cn.springmvc.service;

import cn.springmvc.model.User;

/**
 * Created by baidu on 16/7/12.
 */
public interface UserService {
    public int insertUser(User user);
    public User getUser(int id);
}
