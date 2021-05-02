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
        String sql="select t_id as tid,t_name as tname,t_info as tinfo from type limit 6";
        List<Type> list = queryRunner.query(sql, new BeanListHandler<>(Type.class));
        return list;
    }
}
