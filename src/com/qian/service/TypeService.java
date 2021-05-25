package com.qian.service;

import com.qian.pojo.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeService {
    List<Type> findAll() throws SQLException;

    boolean updateTypeByType(Type type);

    boolean deleteByTid(int i);

    boolean addTypeByType(String typeName, String typeInfo);
}
