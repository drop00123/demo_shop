package com.qian.service;

import com.qian.pojo.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeService {
    List<Type> findAll() throws SQLException;
}
