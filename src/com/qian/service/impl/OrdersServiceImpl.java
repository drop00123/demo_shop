package com.qian.service.impl;

import com.qian.dao.OrdersDao;
import com.qian.dao.impl.OrdersDaoImpl;
import com.qian.pojo.Orders;
import com.qian.service.OrdersService;
import com.qian.utils.RandomUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    private OrdersDao ordersDao;
    public OrdersServiceImpl() {
        ordersDao=new OrdersDaoImpl();
    }

    @Override
    public void createOrder(String aid, String uid, String sum) {
        String orderId = RandomUtils.createOrderId();
        Orders orders = new Orders();
        orders.setOid(orderId);
        orders.setOstate(1);
        orders.setAid(Integer.parseInt(aid));
        orders.setUid(Integer.parseInt(uid));
        orders.setOtime(new Date());
        BigDecimal aSum= new BigDecimal(sum);
        orders.setOcount(aSum);
        ordersDao.insertOrders(orders);
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.deleteCart(uid);
    }

    @Override
    public List<Orders> findOrdersByUid(int uid) {
        List<Orders> list=ordersDao.selectOrdersByUid(uid);
        return list;
    }

    @Override
    public void deleteByOid(String oid) {
        ordersDao.updateOrdersByOid(oid);
    }

    @Override
    public void changeStateByOid(String oid,int oState) {
        ordersDao.updateStateByOid(oid,oState);
    }
}
