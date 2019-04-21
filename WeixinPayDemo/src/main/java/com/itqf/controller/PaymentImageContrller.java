package com.itqf.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 网络不好的情况下得到生成的二维码
 */
@WebServlet("/paymentImage")
public class PaymentImageContrller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //网络不好的情况下重新取一下就行了，响应到页面
        BufferedImage image = (BufferedImage) req.getSession().getAttribute("image");
        //通过ImageIO工具输出到页面进行展示
        if (image != null) {
            ImageIO.write(image,"jpeg",resp.getOutputStream());
        }
    }
}
