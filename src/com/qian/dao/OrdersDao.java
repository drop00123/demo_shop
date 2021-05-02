package com.qian.dao;

import com.qian.pojo.Orders;

import java.util.List;

public interface OrdersDao {
    void insertOrders(Orders orders);

    List<Orders> selectOrdersByUid(int uid);

    void updateOrdersByOid(String oid);

    void updateStateByOid(String oid,int oState);
}
