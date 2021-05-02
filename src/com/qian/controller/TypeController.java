package com.qian.controller;

import com.google.gson.Gson;
import com.qian.pojo.Type;
import com.qian.service.TypeService;
import com.qian.service.impl.TypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/type")
public class TypeController extends BaseServlet{
    private TypeService typeService;
    public TypeController() {
        typeService=new TypeServiceImpl();
    }
    public String  findAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Type> all = typeService.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(all);
        return json;
    }
}
