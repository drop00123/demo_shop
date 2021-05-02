package com.qian.controller;

import cn.dsna.util.images.ValidateCode;
import com.qian.utils.Constants;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/code")
public class CodeController extends BaseServlet{
    public void createCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
        * 1.生成验证码
        * 2.放入session
        * 3.向页面写回
        * */
        ValidateCode validateCode = new ValidateCode(100,35,5,5);
        String code = validateCode.getCode();
        req.getSession().setAttribute("code",code);
        validateCode.write(resp.getOutputStream());
    }
}
