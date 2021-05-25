package com.qian.dao.impl;

import com.mysql.cj.util.StringUtils;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.qian.dao.OrdersDao;
import com.qian.pojo.Address;
import com.qian.pojo.Orders;
import com.qian.utils.C3P0Utils;
import com.qian.utils.RandomUtils;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class OrdersDaoImpl implements OrdersDao {
    @Override
    public void insertOrders(Orders orders) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="insert into orders (o_id,u_id,a_id,o_count,o_time,o_state) value(?,?,?,?,?,?)";
        try {
            queryRunner.update(sql,orders.getOid(),orders.getUid(),orders.getAid(),orders.getOcount(),orders.getOtime(), orders.getOstate());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Orders> selectOrdersByUid(int uid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select o.a_id as aid, o.u_id as uid ,a_name as aname, a_phone as aphone,a_detail as adetail\n" +
                ",a_state as astate,o_id as oid ,o_count as ocount ,o_time as o_time,o_state as ostate\n" +
                "from address a join orders o on a.a_id = o.a_id where o.u_id=? order by o_time desc";
        List<Orders> list= new ArrayList<>();
        try {
            List<Map<String, Object>> query = queryRunner.query(sql, new MapListHandler(), uid);
            if(query==null)
            {
                return null;
            }
            for(int i=0;i<query.size();i++)
            {
                Address address = new Address();
                Orders orders = new Orders();
                Date o_time2 = localDateTimeToDate((LocalDateTime) query.get(i).get("o_time"));
                orders.setOtime(o_time2);
                orders.setUid((Integer)query.get(i).get("u_id"));
                orders.setOcount((BigDecimal) query.get(i).get("o_count"));
                orders.setOstate((Integer) query.get(i).get("o_state"));
                orders.setOid((String) query.get(i).get("o_id"));
                orders.setAid((Integer) query.get(i).get("a_id"));
                address.setAname((String) query.get(i).get("a_name"));
                address.setAdetail((String) query.get(i).get("a_detail"));
                address.setAphone((String) query.get(i).get("a_phone"));
                address.setAstate((Integer) query.get(i).get("a_state"));
                orders.setAddress(address);
                list.add(orders);
            }
          return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    @Override
    public void updateOrdersByOid(String oid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="delete from orders where o_id=?";
        try {
            queryRunner.update(sql, oid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStateByOid(String oid,int oState) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update orders set o_state=? where o_id=?";
        try {
            queryRunner.update(sql,oState,oid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Orders> selectAllOrder() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select o_id as oid ,u_name as uname, o.u_id as uid,o_state as ostate,o_time as otime,o_count as ocount from orders as o join user u on u.u_id = o.u_id order by o_time desc ";
        List<Orders> list=new ArrayList<>();
        try {
            List<Map<String, Object>> query = queryRunner.query(sql, new MapListHandler());
            if(query==null)
            {
                return null;
            }
            for(int i=0;i<query.size();i++)
            {
                Orders orders = new Orders();
                orders.setOid((String) query.get(i).get("o_id"));
                orders.setOcount((BigDecimal) query.get(i).get("o_count"));
                orders.setOstate((Integer) query.get(i).get("o_state"));
                Date o_time2 = localDateTimeToDate((LocalDateTime) query.get(i).get("o_time"));
                orders.setOtime(o_time2);
                orders.setUname((String) query.get(i).get("u_name"));
                orders.setUid((Integer) query.get(i).get("u_id"));
                list.add(orders);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Orders> selectOrdersByUsername(String username, String ostate) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="";
        List<Map<String, Object>> query=null;
        List<Orders> list=new ArrayList<>();
        if(username.length()!=0)
        {
            sql="select o_id,o_time,o_count,o_state,u_name from orders o join user u on o.u_id = u.u_id where u_name=? and o_state=?";
            try {
                query = queryRunner.query(sql, new MapListHandler(), username, ostate);
                if(query==null)
                {
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else{
            sql="select o_id,o_time,o_count,o_state,u_name from orders o join user u on o.u_id = u.u_id where o_state=?";
            try {
                 query = queryRunner.query(sql, new MapListHandler(), ostate);
                if(query==null)
                {
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        for(int i=0;i<query.size();i++)
        {
            Orders orders = new Orders();
            orders.setOid((String) query.get(i).get("o_id"));
            orders.setOcount((BigDecimal) query.get(i).get("o_count"));
            orders.setOstate((Integer) query.get(i).get("o_state"));
            Date date = localDateTimeToDate((LocalDateTime) query.get(i).get("o_time"));
            orders.setOtime(date);
            orders.setUname((String) query.get(i).get("u_name"));
            list.add(orders);
        }
        return list;
    }
}
