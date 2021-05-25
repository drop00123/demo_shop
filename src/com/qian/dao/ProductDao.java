package com.qian.dao;

import com.qian.pojo.Product;

import java.util.List;

public interface ProductDao {
    long selectCountByTid(int tid);
    List<Product> selectProductByPage(int page,int pageSize,int tid);
    Product selectByPid(int pid);

    List<Product> selectByPname(int page,int pageSize,String needs);
     long selectCountByPName(String name);

    long selectAllCount();

    List<Product> selectBy(int page, int pageSize);
}
