package com.qian.service;

import com.qian.pojo.Orders;

import java.util.List;

public interface OrdersService {
    void createOrder(String aid, String uid, String sum);

    List<Orders> findOrdersByUid(int uid);

    void deleteByOid(String oid);

    void changeStateByOid(String oid,int oState);
}
