package com.qian.dao.impl;

import com.qian.dao.AddressDao;
import com.qian.pojo.Address;
import com.qian.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public List<Address> selectAddressByUid(int uid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select a_id as aid,u_id as uid,a_name as aname,a_phone as aphone,"+
                "a_detail as adetail ,a_state as astate from address where u_id=? order by a_state desc ";
        try {
            List<Address> query = queryRunner.query(sql, new BeanListHandler<>(Address.class), uid);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAddressByAid(String aid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="delete from address where a_id=?";
        try {
            queryRunner.update(sql,aid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAddress(Address address) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="insert into address (u_id,a_name,a_phone,a_detail,a_state) value(?,?,?,?,?)";
        try {
            queryRunner.update(sql,address.getUid(),address.getAname(),address.getAphone(),address.getAdetail(),address.getAstate());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateAddressDefault(String aid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update address set a_state=1 where a_id=?";
        try {
            queryRunner.update(sql,aid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAddressNotDefault(String aid, int uid) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update address set a_state=0 where a_id!=? and u_id=?";
        try {
            queryRunner.update(sql,aid,uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAddressByAddress(Address address) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update address set a_name=?,a_phone=?,a_detail=? where a_id=?";
        try {
            queryRunner.update(sql, address.getAname(),address.getAphone(),address.getAdetail(),address.getAid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
