package com.qian.service.impl;

import com.qian.dao.ProductDao;
import com.qian.dao.UserDao;
import com.qian.dao.impl.ProductDaoImpl;
import com.qian.pojo.PageBean;
import com.qian.pojo.Product;
import com.qian.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    public ProductServiceImpl() {
      productDao=new ProductDaoImpl();
    }

    @Override
    public PageBean<Product> findPage(int  tid, int pageSize, int currentPage) {
        long l = productDao.selectCountByTid(tid);
        List<Product> products = productDao.selectProductByPage(currentPage, pageSize, tid);
        return new PageBean<Product>(products,currentPage,pageSize,l);
    }

    @Override
    public Product getProduct(int pid) {
        Product product = productDao.selectByPid(pid);
        return product;
    }

    @Override
    public PageBean<Product> findAll(String needs,int pageSize,int currentPage) {
        long l = productDao.selectCountByPName(needs);
        List<Product> list=productDao.selectByPname(currentPage,pageSize,needs);
        PageBean<Product> pageBean = new PageBean<>(list, 1, pageSize, l);
        return pageBean;
    }

    @Override
    public PageBean<Product> showAllGoods(int page, int pageSize) {
        long totalPage=productDao.selectAllCount();
        List<Product> list=productDao.selectBy(page,pageSize);
        PageBean<Product> pageBean = new PageBean<>(list, page, pageSize, totalPage);
        return pageBean;
    }
}
