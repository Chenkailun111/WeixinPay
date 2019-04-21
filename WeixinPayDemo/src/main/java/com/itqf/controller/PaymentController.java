package com.itqf.controller;
import com.itqf.utils.PayCommonUtil;
import com.itqf.utils.ZxingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    /**
     * 接收商品信息，
     * 生成订单编号，
     * 调用腾讯服务器，生成支付二维码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            String name = req.getParameter("name");
            String price =req.getParameter("price");
            String desc ="商品的描述";
            //订单编号，时间戳也不一定唯一，并发情况下
            int userId = 123456;
            String orderId = System.currentTimeMillis()+userId+"";
            //调用微信支付,会生成一个支付的url字符串
            String url = PayCommonUtil.weixin_pay(price, desc, orderId);
            //生成一个BufferImage对象，生成二维码
            BufferedImage image = ZxingUtil.createImage(url,300,300);

            req.getSession().setAttribute("image",image);
            req.getSession().setAttribute("orderId",orderId);
            /**
             * request.getRequestDispatcher("new.jsp").forward(request, response);//转发到new.jsp
             * response.sendRedirect("new.jsp");//重定向到new.jsp
             * 转发地址没变，服务端行为，信息不回丢失
             * 重定向地址有改变，客户端行为，信息会丢失
             */
            resp.sendRedirect("/payment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
