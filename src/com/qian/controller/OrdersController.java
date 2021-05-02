package com.qian.controller;

import com.qian.pojo.Address;
import com.qian.pojo.Cart;
import com.qian.pojo.Orders;
import com.qian.pojo.User;
import com.qian.service.OrdersService;
import com.qian.service.impl.AddressServiceImpl;
import com.qian.service.impl.CartServiceImpl;
import com.qian.service.impl.OrdersServiceImpl;
import com.qian.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
@WebServlet("/order")
public class OrdersController extends BaseServlet {
    private OrdersService ordersService;
    public OrdersController() {
        ordersService=new OrdersServiceImpl();
    }

    public String preView(HttpServletRequest req, HttpServletResponse resp)
    {
        String uid = req.getParameter("uid");
        AddressServiceImpl addressService = new AddressServiceImpl();
        List<Address> addressByUid = addressService.findAddressByUid(Integer.parseInt(uid));
        CartServiceImpl cartService = new CartServiceImpl();
        List<Cart> all = cartService.findAll(Integer.parseInt(uid));
        req.setAttribute("cartList",all);
        req.setAttribute("addressList",addressByUid);
        return "forward:/order.jsp";
    }
    public String create(HttpServletRequest req,HttpServletResponse resp)
    {
        String aid = req.getParameter("aid");
        String uid=req.getParameter("uid");
        String sum = req.getParameter("sum");
        ordersService.createOrder(aid,uid,sum);
        return Constants.FORWARD +"order?method=show";
    }
    public String show(HttpServletRequest req,HttpServletResponse resp)
    {
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser==null)
        {
            req.setAttribute("msg","登录可查看订单");
            return "forward:/login.jsp";
        }
        User user = (User) loginUser;
       List<Orders>  list=ordersService.findOrdersByUid(user.getUid());
       req.setAttribute("ordersList",list);
       return "forward:/orderList.jsp";
    }
    public String delete(HttpServletRequest req,HttpServletResponse resp)
    {
        String oid = req.getParameter("oid");
        ordersService.deleteByOid(oid);
        return "forward:/order?method=show";
    }
    public String pay(HttpServletRequest req,HttpServletResponse resp)
    {
        String oid=req.getParameter("oid");
        int oState=2;
        ordersService.changeStateByOid(oid,oState);
        return "forward:/order?method=show";
    }
    public String changeStatus(HttpServletRequest req,HttpServletResponse  resp)
    {
        String oid=req.getParameter("oid");
        int oState=4;
        ordersService.changeStateByOid(oid,oState);
        return "forward:/order?method=show";
    }
}
