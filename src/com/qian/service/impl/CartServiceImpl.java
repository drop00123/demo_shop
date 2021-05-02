package com.qian.service.impl;

import com.qian.dao.CartDao;
import com.qian.dao.impl.CartDaoImpl;
import com.qian.dao.impl.ProductDaoImpl;
import com.qian.pojo.Cart;
import com.qian.pojo.Product;
import com.qian.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao;
    public CartServiceImpl() {
        cartDao = new CartDaoImpl();
    }

    @Override
    public void createCart(int uid, int pid) {

        Cart cart = cartDao.hasCart(uid, pid);
        if(cart!=null)
        {
            cart.setCnum(cart.getCnum()+1);
            cartDao.updateCart(cart);
        }
        else
        {
            ProductDaoImpl productDao = new ProductDaoImpl();
            Product product = productDao.selectByPid(pid);
            cart= new Cart();
            cart.setCnum(1);
            cart.setPid(pid);
            cart.setUid(uid);
            cart.setProduct(product);
            cartDao.insertCart(cart);
        }
    }

    @Override
    public List<Cart> findAll(int uid) {
        List<Cart> carts = cartDao.selectCartsByUid(uid);
        return carts;
    }

    @Override
    public void deleteByCid(int i) {
        cartDao.deleteCart(i);
    }

    @Override
    public void updateCart(int cid, int price, int cnum) {
        cartDao.updateCartByCid(cid,price,cnum);
    }

    @Override
    public void deleteCart(String uid) {
        cartDao.deleteCartByUid(uid);
    }
}
