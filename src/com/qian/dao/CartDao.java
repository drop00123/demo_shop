package com.qian.dao;

import com.qian.pojo.Cart;

import java.util.List;

public interface CartDao {
    Cart hasCart(int uid,int pid);

    void updateCart(Cart cart);

    void insertCart(Cart cart);


    List<Cart> selectCartsByUid(int uid);

    void deleteCart(int i);

    void updateCartByCid(int cid, int price, int cnum);

    void deleteCartByUid(String uid);
}
