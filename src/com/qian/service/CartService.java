package com.qian.service;

import com.qian.pojo.Cart;

import java.util.List;

public interface CartService {
    public void createCart(int uid,int pid);

    List<Cart> findAll(int uid);

    void deleteByCid(int i);

    void updateCart(int cid, int price, int cnum);

    void deleteCart(String uid);
}
