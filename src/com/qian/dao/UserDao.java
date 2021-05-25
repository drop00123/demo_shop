package com.qian.dao;

import com.qian.pojo.Message;
import com.qian.pojo.Product;
import com.qian.pojo.Type;
import com.qian.pojo.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface UserDao {
    User selectUserByName(String name) throws ClassNotFoundException, SQLException;
    int insertUser(User user) throws SQLException;
    User selectUserByCode(String code) throws SQLException;
    int updateStatusById(int id) throws SQLException;

    void insertMessage(int id, String content, LocalDateTime date);

    List<Message> queryBbs();

    long queryPage();

    List<Message> queryList(int page, int pageSize);

    int updatePwdByUid(int uid, String pwd);

    List<User> queryUserList(int page, int pageSize);

    long queryPageUser();
}
