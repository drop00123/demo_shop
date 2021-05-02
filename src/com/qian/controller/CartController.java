package com.qian.controller;

import com.qian.pojo.Cart;
import com.qian.pojo.User;
import com.qian.service.CartService;
import com.qian.service.impl.CartServiceImpl;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/cart")
public class CartController extends BaseServlet{
    private CartService cartService;
    public CartController() {
        cartService =new CartServiceImpl();
    }

    public String create(HttpServletRequest req, HttpServletResponse resp)
    {
        HttpSession session = req.getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser==null)
        {
            session.setAttribute("msg","添加购物车必须先登录");
            return "forward:/login.jsp";
        }
        int uid = loginUser.getUid();
        String pid = req.getParameter("pid");
        int i = Integer.parseInt(pid);
        cartService.createCart(uid,i);
        return "forward:/cartSuccess.jsp";
    }
    public String show(HttpServletRequest req,HttpServletResponse resp)
    {
        HttpSession session = req.getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser==null)
        {
            session.setAttribute("msg","添加购物车需先登录");
            return "forward:/login.jsp";
        }
        int uid = loginUser.getUid();
        List<Cart> all = cartService.findAll(uid);
        req.setAttribute("list",all);
        return "forward:/cart.jsp";
    }
    public String delete(HttpServletRequest req,HttpServletResponse resp)
    {
        String cid = req.getParameter("cid");
        int i = Integer.parseInt(cid);
        cartService.deleteByCid(i);
        return "forward:/cart?method=show";
    }
    public String update(HttpServletRequest req,HttpServletResponse resp)
    {
        String cid1 = req.getParameter("cid");
        String price1= req.getParameter("price");
        String cnum1 = req.getParameter("cnum");
        int cid= Integer.parseInt(cid1);
        int price= Integer.parseInt(price1);
        int cnum=Integer.parseInt(cnum1);
        cartService.updateCart(cid,price,cnum);
        return "forward:/cart?method=show";
    }
    public String clear(HttpServletRequest req,HttpServletResponse resp)
    {
        String uid = req.getParameter("uid");
        cartService.deleteCart(uid);
        return "forward:/cart?method=show";
    }
}
