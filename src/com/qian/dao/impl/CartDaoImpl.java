package com.qian.dao.impl;


import com.qian.dao.CartDao;
import com.qian.pojo.Cart;
import com.qian.pojo.Product;
import com.qian.utils.C3P0Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {
    @Override
    public Cart hasCart(int uid, int pid){

        //cart --> product 连接查询 多表查询
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "select p.p_name as pname,p.p_id as pid,p.t_id as tid," +
                "p.p_time as ptime,p.p_image as pimage,p_state as pstate," +
                "p.p_info as pinfo, p.p_price as pprice,c.c_id as cid,c.u_id as uid,c.c_count as ccount," +
                "c.c_num as cnum from product p join cart c on p.p_id = c.p_id where" +
                " c.u_id = ? and c.p_id = ?;";
        try {
            Cart query = queryRunner.query(sql, new BeanHandler<>(Cart.class), uid, pid);
            if(query==null)
            {
                return null;
            }
            ProductDaoImpl productDao = new ProductDaoImpl();
            Product product = productDao.selectByPid(pid);
            query.setProduct(product);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCart(Cart cart) {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "update cart set c_num = ? , c_count = ? where c_id = ?";

        try {
            queryRunner.update(sql, cart.getCnum(),cart.getCcount(),cart.getCid());
        } catch (SQLException throwables) {
        }

    }

    @Override
    public void insertCart(Cart cart) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "insert into cart (u_id,p_id,c_num,c_count) value(?,?,?,?)";

        try {
            queryRunner.update(sql, cart.getUid(),cart.getProduct().getPid(),cart.getCnum(),cart.getCcount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Cart> selectCartsByUid(int uid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        List<Cart> carts=null;
        String sql = "select p.p_name as pname,p.p_id as pid,p.t_id as tid," +
                "p.p_time as ptime,p.p_image as pimage,p_state as pstate," +
                "p.p_info as pinfo, p.p_price as pprice,c.c_id as cid,c.u_id as uid,c.c_count as ccount," +
                "c.c_num as cnum from product p join cart c on p.p_id = c.p_id where" +
                " c.u_id = ? ";

        List<Map<String, Object>> list = null;
        try {
            list = queryRunner.query(sql, new MapListHandler(), uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (list == null) {
                return null;
            }
            carts = new ArrayList<>();
            for (Map<String, Object> map : list) {
                Cart cart = new Cart();
                Product product = new Product();
                product.setPprice((BigDecimal) map.get("p_price"));
                product.setPname((String) map.get("p_name"));
                cart.setCid((Integer) map.get("c_id"));
                cart.setCcount((BigDecimal) map.get("c_count"));
                cart.setCnum((Integer) map.get("c_num"));
                cart.setProduct(product);
                carts.add(cart);
            }
        return  carts;
    }

    @Override
    public void deleteCart(int i) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="delete from cart where c_id=?";
        try {
           queryRunner.update(sql, i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateCartByCid(int cid, int price, int cnum) {
        long count=price*cnum;
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update cart set c_count=?,c_num=? where c_id=?";
        try {
            queryRunner.update(sql,count,cnum,cid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCartByUid(String uid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="delete from cart where u_id=?";
        try {
            queryRunner.update(sql,uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
