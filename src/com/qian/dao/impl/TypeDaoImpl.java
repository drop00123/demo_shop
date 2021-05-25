package com.qian.dao.impl;

import com.qian.dao.TypeDao;
import com.qian.pojo.Type;
import com.qian.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    @Override
    public List<Type> selectAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="select t_id as tid,t_name as tname,t_info as tinfo from type limit 7";
        List<Type> list = queryRunner.query(sql, new BeanListHandler<>(Type.class));
        return list;
    }

    @Override
    public boolean updateTypes(Type type) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="update type set t_name=?,t_info=? where t_id=?;";
        try {
            int update = queryRunner.update(sql, type.getTname(), type.getTinfo(), type.getTid());
            if(update!=0)
            {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTypeByTid(int i) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="delete from type where t_id=?; ";
        try {
            int update = queryRunner.update(sql, i);
            if(update!=0)
            {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return false;
    }

    @Override
    public boolean insertType(String typeName, String typeInfo) {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql="insert into type(t_name, t_info) VALUE (?,?);";
        try {
            int update = queryRunner.update(sql, typeName, typeInfo);
            if(update!=0)
            {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
