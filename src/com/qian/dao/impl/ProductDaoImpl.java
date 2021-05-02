package com.qian.dao.impl;

import com.google.gson.Gson;
import com.qian.dao.ProductDao;
import com.qian.pojo.Product;
import com.qian.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public long selectCountByTid(int tid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select count(1) from product where t_id=?";
        try {
            Object query = queryRunner.query(sql, new ScalarHandler(), tid);
            Long total=(Long)query;
            return total;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Product> selectProductByPage(int page, int pageSize, int tid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select p_id as pid,t_id as tid,p_name as pname,p_time as ptime ," +
                "p_image as pimage,p_state as pstate ,p_info as pinfo ,p_price as pprice " +
                "from product where t_id = ? limit ?,?;";
        try {
            List<Product> query = queryRunner.query(sql, new BeanListHandler<>(Product.class), tid, (page - 1) * pageSize, pageSize);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Product selectByPid(int pid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select p_id as pid,t_id as tid,p_name as pname,p_time as ptime ," +
                "p_image as pimage,p_state as pstate ,p_info as pinfo ,p_price as pprice " +
                "from product where p_id =?";
        try {
            Product query = queryRunner.query(sql, new BeanHandler<>(Product.class), pid);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> selectByPname(int page,int pageSize,String needs) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql= " select p_id as pid,t_id as tid,p_name as pname,p_time as ptime ,p_image as pimage,p_state as pstate ,p_info as pinfo ,p_price as pprice from product where p_name like ? limit ?,?" ;
        try {
            List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), "%"+needs+"%",(page-1)*pageSize,pageSize);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCountByPName(String name) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select count(1) from product where p_name like ?";
        try {
            Object query = queryRunner.query(sql, new ScalarHandler(), "%"+name+"%");
            Long total=(Long)query;
            return total;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
