package com.qian.dao.impl;


import com.qian.dao.UserDao;
import com.qian.pojo.Message;
import com.qian.pojo.Type;
import com.qian.pojo.User;
import com.qian.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserByName(String name) throws ClassNotFoundException, SQLException {
       QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String  sql = "select u_id as uid , u_name as username , u_password as upassword" +
                ", u_sex as usex , u_status as ustatus , u_code as code , u_email as email " +
                ", u_role as urole from user where u_name = ?";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), name);
        return user;
    }

    @Override
    public int insertUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user (u_name,u_password,u_sex,u_status,u_code,u_email,u_role) value (?,?,?,?,?,?,?)";
        int i = queryRunner.update(sql, user.getUsername(), user.getUpassword(), user.getUsex(),
                user.getUstatus(), user.getCode(), user.getEmail(), user.getUrole());
        return i;
    }

    @Override
    public User selectUserByCode(String code) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String  sql = "select u_id as uid , u_name as username , u_password as upassword" +
                ", u_sex as usex , u_status as ustatus , u_code as code , u_email as email " +
                ", u_role as urole from user where u_code = ?";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), code);
        return user;
    }

    @Override
    public int updateStatusById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update user set u_status=? where u_id=?";
        int row = queryRunner.update(sql, 1, id);
        return row;
    }

    @Override
    public void insertMessage(int id, String content, LocalDateTime date) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="insert into message (u_id,m_content, m_time) VALUE (?,?,?)";
        try {
            queryRunner.update(sql,id,content,date);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Message> queryBbs() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select u_name as username,m_time as mDate,m_content as mContent from message as m join user as u on m.u_id=u.u_id ";
        try {
            List<Message> list = queryRunner.query(sql, new BeanListHandler<Message>(Message.class));
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public long queryPage() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select count(1) from message ";
        try {
            long count=(long) queryRunner.query(sql, new ScalarHandler());
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Message> queryList(int page, int pageSize) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select u_name as username,m_time as mDate,m_content as mContent from message as m join user as u on m.u_id=u.u_id limit ?,?";
        try {
            List<Message> list = queryRunner.query(sql, new BeanListHandler<>(Message.class), (page - 1) * pageSize, pageSize);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int updatePwdByUid(int uid, String pwd) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update user set u_password=? where u_id=?;";
        try {
            int update = queryRunner.update(sql, pwd, uid);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> queryUserList(int page, int pageSize) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select u_name as username ,u_email as email,u_status as ustatus,u_role as urole ,u_sex as usex from user limit ?,?";
        try {
            List<User> query = queryRunner.query(sql, new BeanListHandler<>(User.class), (page - 1) * pageSize, pageSize);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public long queryPageUser() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select count(1) from user ";
        try {
            long count=(long) queryRunner.query(sql, new ScalarHandler());
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}