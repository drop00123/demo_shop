package com.qian.dao;

import com.qian.pojo.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDao {
    List<Type> selectAll() throws SQLException;

    boolean  updateTypes(Type type);

    boolean deleteTypeByTid(int i);

    boolean insertType(String typeName, String typeInfo);
}
