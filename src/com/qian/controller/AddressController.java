package com.qian.controller;

import com.qian.pojo.Address;
import com.qian.pojo.User;
import com.qian.service.AddressService;
import com.qian.service.impl.AddressServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.util.resources.cldr.da.CalendarData_da_DK;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/address")
public class AddressController extends BaseServlet{
    private AddressService addressService;
    public AddressController() {
        addressService=new AddressServiceImpl();
    }
    public String show(HttpServletRequest req, HttpServletResponse resp)
    {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loginUser");
        if(user==null)
        {
            session.setAttribute("msg","请先登录");
            return "forward:/login.jsp";
        }
        int uid = user.getUid();
        List<Address> list=addressService.findAddressByUid(uid);
        req.setAttribute("list",list);
        return "forward:/self_info.jsp";
    }
    public String add(HttpServletRequest req,HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map= req.getParameterMap();
        Address address = new Address();
        BeanUtils.populate(address,map);
        addressService.addAddress(address);
        return "forward:/address?method=show";
    }
    public String delete(HttpServletRequest req,HttpServletResponse resp)
    {
        String aid = req.getParameter("aid");
        addressService.deleteAddress(aid);
        return "forward:/address?method=show";
    }
    public String setDefault(HttpServletRequest req,HttpServletResponse resp)
    {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loginUser");
        int uid = user.getUid();
        String aid = req.getParameter("aid");
        addressService.setAddressDefault(aid,uid);
        return "forward:/address?method=show";
    }
    public String update(HttpServletRequest req,HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Address address = new Address();
        BeanUtils.populate(address,parameterMap);
        addressService.updateAddress(address);
        return "forward:/address?method=show";
    }
}
