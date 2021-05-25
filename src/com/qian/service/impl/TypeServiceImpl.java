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

    @Override
    public boolean updateTypeByType(Type type) {
        boolean flag=typeDao.updateTypes(type);
        return flag;
    }

    @Override
    public boolean deleteByTid(int i) {
        boolean b = typeDao.deleteTypeByTid(i);
        return b;
    }

    @Override
    public boolean addTypeByType(String typeName, String typeInfo) {
       boolean flag= typeDao.insertType(typeName,typeInfo);
        return flag;
    }
}
