package com.qian.controller;

import com.qian.pojo.*;
import com.qian.service.OrdersService;
import com.qian.service.ProductService;
import com.qian.service.TypeService;
import com.qian.service.UserService;
import com.qian.service.impl.OrdersServiceImpl;
import com.qian.service.impl.ProductServiceImpl;
import com.qian.service.impl.TypeServiceImpl;
import com.qian.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/admin")
public class AdminController extends BaseServlet{
    private UserService userService;
    private ProductService productService;
    private OrdersService ordersService;
    private TypeService typeService;
    public AdminController() {
        userService=new UserServiceImpl();
        productService=new ProductServiceImpl();
        ordersService=new OrdersServiceImpl();
        typeService=new TypeServiceImpl();
    }
    public String typeShow(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Type> all = typeService.findAll();
        req.setAttribute("goodsTypeList", all);
        return "forward:/admin/showGoodsType.jsp";
    }
    public String updateType(HttpServletRequest req,HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Type type = new Type();
        BeanUtils.populate(type,parameterMap);
        System.out.println(type);
        boolean flag=typeService.updateTypeByType(type);
        if(flag)
        {
            return "forward:/admin?method=typeShow";
        }
        req.setAttribute("msg","修改类型失败,系统异常");
        return "forward:/message.jsp";
    }
    public String deleteType(HttpServletRequest  req,HttpServletResponse  resp)
    {
        String tid = req.getParameter("tid");
        int i=0;
        if(tid!=null)
        {
            i = Integer.parseInt(tid);
        }
        boolean b = typeService.deleteByTid(i);
        if(b)
        {
            return "forward:/admin?method=typeShow";
        }
       req.setAttribute("msg","删除失败,程序异常");
        return "forward:/message.jsp";
    }
    public String addType(HttpServletRequest req,HttpServletResponse resp)
    {
        String typeName = req.getParameter("typeName");
        String typeInfo = req.getParameter("typeInfo");
        boolean flag=typeService.addTypeByType(typeName,typeInfo);
        if(flag)
        {
            return "forward:/admin?method=typeShow";
        }
        req.setAttribute("msg","类型添加失败,程序异常");
        return "forward:/message.jsp";
    }
    public String goodsShow(HttpServletRequest req,HttpServletResponse  resp)
    {
        int pageSize=100;
        int page=1;
        String currentPage = req.getParameter("page");
        System.out.println(currentPage);
        if(currentPage!=null)
        {
            int i = Integer.parseInt(currentPage);
            page=i;
        }
        PageBean<Product>  list =productService.showAllGoods(page,pageSize);
        req.setAttribute("goodsList",list);
        return "forward:/admin/showGoods.jsp";
    }
    public String addGoods(HttpServletRequest req,HttpServletResponse resp)
    {
        System.out.println("进来了");
        String name = req.getParameter("tname");
        System.out.println(name);
        String picture = req.getParameter("picture");
        System.out.println(picture);
        return "";
    }
    public String getAllOrder(HttpServletRequest req,HttpServletResponse resp)
    {
       List<Orders> list= ordersService.findAllOrder();
       if(list!=null)
       {
           req.setAttribute("orderList",list);
           return "forward:/admin/showAllOrder.jsp";
       }
       req.setAttribute("msg","程序异常");
        return "forward:/message.jsp";
    }
    public String searchOrder(HttpServletRequest req,HttpServletResponse resp)
    {
        String username = req.getParameter("username");
        String ostate = req.getParameter("ostate");
            List<Orders> list=ordersService.findOrdersByUname(username,ostate);
            if(list!=null)
            {
                req.setAttribute("orderList",list);
                return "forward:/admin/showAllOrder.jsp";
            }
            req.setAttribute("msg","程序异常");
            return "forward:/message.jsp";

    }
    public String sendOrder(HttpServletRequest req,HttpServletResponse resp)
    {
        String oid = req.getParameter("oid");
        int ostate=3;
        if(oid!=null)
        {
            ordersService.changeStateByOid(oid,ostate);
            return "forward:/admin?method=getAllOrder";
        }
        req.setAttribute("msg","程序异常");
        return "forward:/message.jsp";
    }
    public String getUserList(HttpServletRequest req,HttpServletResponse resp)
    {
        String currentPage = req.getParameter("currentPage");
        int  page=1;int pageSize=10;
        if(currentPage!=null)
        {
            page=Integer.parseInt(currentPage);
        }
        PageBean<User> pageBean=userService.findAllUser(page,pageSize);
        req.setAttribute("pageBean",pageBean);
        return "forward:/admin/userList.jsp";
    }
}
