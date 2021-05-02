package com.qian.service.impl;

import com.qian.dao.TypeDao;
import com.qian.dao.impl.TypeDaoImpl;
import com.qian.pojo.Type;
import com.qian.service.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao;
    public TypeServiceImpl() {
         typeDao=new TypeDaoImpl();
    }

    @Override
    public List<Type> findAll() throws SQLException {
        List<Type> types = typeDao.selectAll();
        return types;
    }
}
