package com.qian.service.impl;

import com.qian.dao.UserDao;
import com.qian.dao.impl.UserDaoImpl;
import com.qian.pojo.Message;
import com.qian.pojo.PageBean;
import com.qian.pojo.Type;
import com.qian.pojo.User;
import com.qian.service.UserService;
import com.qian.utils.EmailUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl()
    {
        userDao=new UserDaoImpl();
    }


    @Override
    public boolean checkUser(String name) throws SQLException, ClassNotFoundException {
        User user = userDao.selectUserByName(name);
        if(user!=null)
        {
            return true;
        }
        return false;
    }

    @Override
    public int registerUser(User user) throws SQLException {
        int i = userDao.insertUser(user);
        EmailUtils.sendEmail(user);
        return i;
    }
    @Override
    public int activeUser(String code) throws SQLException {
        User user = userDao.selectUserByCode(code);
        if(user==null)
        {
            return 0;//fail
        }
        if(user.getUstatus().equals(1))
        {
            return 2;//已经激活
        }
        int i = userDao.updateStatusById(user.getUid());
        if(i>0)
        {
            return 1;//成功激活
        }
        return 0;
    }

    @Override
    public User GetUser(String name) throws SQLException, ClassNotFoundException {
        User user = userDao.selectUserByName(name);
        return user;
    }

    @Override
    public void createBbs(int id, String content) {


        /*Date date = new Date();*/
        LocalDateTime date = LocalDateTime.now();
        userDao.insertMessage(id,content,date);
    }

    @Override
    public List<Message> getAllBbs() {
        List<Message> list=userDao.queryBbs();
        return list;
    }

    @Override
    public PageBean<Message> findAll(int page, int pageSize) {
        long totalPage=userDao.queryPage();
        List<Message> list=userDao.queryList(page,pageSize);
        PageBean<Message> pageBean = new PageBean<>(list, page, pageSize, totalPage);
        return pageBean;
    }

    @Override
    public boolean updateNewPwd(int uid, String pwd) {
       int i= userDao.updatePwdByUid(uid,pwd);
       if(i!=0)
       {
           return true;
       }
        return false;
    }

    @Override
    public boolean checkPwd(String code,String pwd) {
        try {
            User user = userDao.selectUserByCode(code);
            String uPassword = user.getUpassword();
            if(pwd.equals(uPassword))
            {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public PageBean<User> findAllUser(int page, int pageSize) {
        long totalPage=userDao.queryPageUser();
        List<User>  list=userDao.queryUserList(page,pageSize);
        PageBean<User> pageBean = new PageBean<>(list, page, pageSize, totalPage);
        return pageBean;
    }
}
