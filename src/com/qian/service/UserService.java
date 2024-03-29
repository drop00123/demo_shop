package com.qian.service;

import com.qian.pojo.Message;
import com.qian.pojo.PageBean;
import com.qian.pojo.Type;
import com.qian.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    boolean checkUser(String name) throws SQLException, ClassNotFoundException;
    User GetUser(String name) throws SQLException, ClassNotFoundException;
    int registerUser(User user) throws SQLException;
    int activeUser(String code) throws SQLException;

    void createBbs(int id, String content);

    List<Message> getAllBbs();

    PageBean<Message> findAll(int page, int pageSize);

    boolean updateNewPwd(int uid, String pwd);

    boolean checkPwd(String s,String pwd);

    PageBean<User> findAllUser(int page, int pageSize);
}
