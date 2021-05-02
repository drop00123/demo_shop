package com.qian.controller;

import com.google.gson.Gson;
import com.qian.pojo.PageBean;
import com.qian.pojo.Product;
import com.qian.service.ProductService;
import com.qian.service.impl.ProductServiceImpl;
import com.qian.utils.Constants;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends BaseServlet{
    private ProductService productService;
    public ProductController() {
        productService=new ProductServiceImpl();
    }

    public String show(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tid = req.getParameter("tid");
        int i = Integer.parseInt(tid);
        int pageSize=8;
        String currentPage = req.getParameter("currentPage");
        int page=1;
        if(currentPage!=null)
        {
            page=Integer.parseInt(currentPage);
        }
        PageBean<Product> page1 = productService.findPage(i, pageSize, page);
        req.setAttribute("pageBean",page1);
        return "forward:/goodsList.jsp";
    }
    public String detail(HttpServletRequest request,HttpServletResponse response) throws SQLException {

        //1.获取请求参数
        String pid = request.getParameter("pid");
        int i=Integer.parseInt(pid);
        //2.调用业务逻辑
        Product product = productService.getProduct(i);
        //3.响应
        request.setAttribute("product", product);
        return Constants.FORWARD + "/goodsDetail.jsp";
    }
    public String findNeed(HttpServletRequest req,HttpServletResponse resp)
    {
        int currentPage=1;
        int pageSize=8;
        String needs = req.getParameter("needs");
        PageBean<Product> pageBean=productService.findAll(needs,pageSize,currentPage);
        req.setAttribute("pageBean",pageBean);
        return "forward:/goodsList.jsp";
    }

}
