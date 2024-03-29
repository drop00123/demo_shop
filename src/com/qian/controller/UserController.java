package com.qian.controller;

import com.mysql.cj.util.StringUtils;
import com.qian.pojo.Message;
import com.qian.pojo.PageBean;
import com.qian.pojo.User;
import com.qian.service.UserService;
import com.qian.service.impl.UserServiceImpl;
import com.qian.utils.Base64Utils;
import com.qian.utils.Constants;
import com.qian.utils.MD5Utils;
import com.qian.utils.RandomUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/user")
public class UserController extends BaseServlet{
    private UserService userService;
    public UserController() {
        userService=new UserServiceImpl();
    }
    public String check(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException {
        String name = req.getParameter("username");
        if(StringUtils.isNullOrEmpty(name))
        {
            return Constants.HAS_USER;
        }
        else
        {
            boolean b = userService.checkUser(name);
            if(b)
            {
                return Constants.HAS_USER;
            }
            else
            {
                return Constants.NOT_HAS_USER;
            }
        }
    }
    public String register(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        BeanUtils.populate(user,map);
        user.setUstatus("0");//1 激活
        user.setUrole(0);//1 管理员
        user.setCode(RandomUtils.createActive());//激活码
        user.setUpassword(MD5Utils.md5(user.getUpassword()));//md5加密密码
        try {
            userService.registerUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            req.setAttribute("registerMsg","注册失败!");
            return "forward:/register.jsp";
        }
        return "forward:/registerSuccess.jsp";
    }
    public String active(HttpServletRequest req,HttpServletResponse resp) throws SQLException {
        //获取激活码 已base64
        String c = req.getParameter("c");
        String code = Base64Utils.decode(c);
        int i = userService.activeUser(code);
        if(i==0)
        {
            req.setAttribute("msg","未激活成功");
        }
        else if(i==1)
        {
            req.setAttribute("msg","激活成功,请登录");
        }
        else
        {
            req.setAttribute("msg","已经激活");
        }
        return "forward:/message.jsp";
    }

    public String login(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ClassNotFoundException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String s = MD5Utils.md5(password);
        String code=req.getParameter("code");
        String code1 =(String)req.getSession().getAttribute("code");
        User user = userService.GetUser(username);
        if(user.getUrole()==1)
        {
            req.getSession().setAttribute("adminUser",user);
            return "forward:/admin/admin.jsp";
        }
        req.getSession().setAttribute("loginUser",user);
        return "forward:/index.jsp";
       /*if(code.equalsIgnoreCase(code1))
        {
            User user = userService.GetUser(username);
           if(user!=null&user.getUpassword().equals(s))
            {
                if(user.getUrole()==1)
                {
                    req.getSession().setAttribute("adminUser",user);
                    return "forward:/admin/admin.jsp";
                }else if(user.getUrole()==0)
                {
                    req.getSession().setAttribute("loginUser",user);
                    return "forward:/index.jsp";
                }
                else
                {
                    req.setAttribute("msg","账号或密码错误");
                }
               String auto = req.getParameter("auto");
                if(auto==null) {
                    Cookie cookie = new Cookie("auto", "");
                    cookie.setPath("/"); //当前项目下所有资源都能访问
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
                else
                {
                    String content=username+":"+password;
                    content=Base64Utils.encode(content);
                    Cookie cookie = new Cookie("auto", content);
                    cookie.setPath("/");
                    cookie.setMaxAge(14*24*60*60);
                    resp.addCookie(cookie);
                }
            }
            else
            {
                req.setAttribute("msg","账号或者密码错误");
                return "forward:/login.jsp";
            }
        }
        req.setAttribute("msg","验证码错误");
        return "forward:/login.jsp";*/
    }
    public String logOut(HttpServletRequest req,HttpServletResponse resp)
    {
        req.getSession().removeAttribute("loginUser");//清空session中的用户数据
        Cookie cookie = new Cookie("auto","");
        cookie.setPath("/");
        cookie.setMaxAge(0);//清空和覆盖cookie存储的自动登录信息
        resp.addCookie(cookie);
        //转发到登录页面
        req.setAttribute("msg","注销登录成功");
        return "forward:/message.jsp";
    }
    public String loginOut(HttpServletRequest req,HttpServletResponse resp)
    {
        req.getSession().removeAttribute("adminUser");//清空session中的用户数据
        Cookie cookie = new Cookie("auto","");
        cookie.setPath("/");
        cookie.setMaxAge(0);//清空和覆盖cookie存储的自动登录信息
        resp.addCookie(cookie);
        //转发到登录页面
        req.setAttribute("msg","注销登录成功");
        return "forward:/message.jsp";
    }
    public String addBbs(HttpServletRequest req,HttpServletResponse resp)
    {
        Object loginUser = req.getSession().getAttribute("loginUser");
        if(loginUser==null)
        {
            req.setAttribute("msg","请先登录");
            return "forward:/login.jsp";
        }
        else
        {
            User user = (User) loginUser;
            int id = user.getUid();
            String content = req.getParameter("bbs");
            userService.createBbs(id,content);
            req.setAttribute("msg","评论成功,感谢你的建议!");
        }
        return "forward:/message.jsp";
    }
    public String show(HttpServletRequest req,HttpServletResponse resp)
    {
        int pageSize=5;
        String currentPage = req.getParameter("currentPage");
        int page=1;
        if(currentPage!=null)
        {
           page = Integer.parseInt(currentPage);
        }
        PageBean<Message> pageBean= userService.findAll(page,pageSize);
        req.setAttribute("pageBean",pageBean);
        return "forward:/bbsDetail.jsp";
    }
    public String prove(HttpServletRequest req,HttpServletResponse resp)
    {
        Object loginUser = req.getSession().getAttribute("loginUser");
        if(loginUser==null)
        {
            req.setAttribute("msg","请先登录");
            return "forward:/login.jsp";
        }
        User user= (User) loginUser;
        String code = user.getCode();
        String pwd = req.getParameter("oldPassword");
        if(!StringUtils.isNullOrEmpty(pwd))
        {
            String s = MD5Utils.md5(pwd);
            boolean flag=userService.checkPwd(code,s);
            if(flag)
            {
                return "1";
            }
        }
        return "0";
    }
    public String updatePwd(HttpServletRequest req,HttpServletResponse resp)
    {
        Object loginUser = req.getSession().getAttribute("loginUser");
        if(loginUser==null)
        {
            req.setAttribute("msg","请先登录");
            return "forward:/login.jsp";
        }
        User user = (User) loginUser;
        int uid = user.getUid();
        String newPwd = req.getParameter("password");
        String pwd = MD5Utils.md5(newPwd);
        boolean flag=userService.updateNewPwd(uid,pwd);
        if(flag)
        {
            req.setAttribute("msg","修改密码成功,请重新登录");
            req.getSession().removeAttribute("loginUser");
            Cookie cookie = new Cookie("auto", "");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            return "forward:/message.jsp";
        }
        req.setAttribute("msg","程序异常,修改密码失败");
        return "forward:/message.jsp";
    }
    public String myself(HttpServletRequest req,HttpServletResponse resp)
    {
        Object loginUser = req.getSession().getAttribute("loginUser");
        if(loginUser==null)
        {
            req.setAttribute("msg","请先登录");
            return "forward:/login.jsp";
        }
        User user = (User) loginUser;
        req.setAttribute("u",user);
        return "forward:/myself.jsp";
    }
}
