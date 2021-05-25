package com.qian.service;

import com.qian.pojo.PageBean;
import com.qian.pojo.Product;

import java.util.List;

public interface ProductService {
    PageBean<Product> findPage(int tid,int pageSize,int currentPage);
    Product getProduct(int pid);

    PageBean<Product> findAll(String needs,int pageSize,int currentPage);


    PageBean<Product> showAllGoods(int page,int pageSize);
}
