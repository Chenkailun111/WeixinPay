package com.itqf.utils;

/**
 * @Auther: Administrator
 * Thanks for Everything
 * 用于配置上述需要的信息
 * 公司中使用
 */
public class PayConfigUtil {
    public static String APP_ID = "wx632c8f211f8122c6"; //微信注册时公司给的商户号，公司专用
    public static String MCH_ID = "1497984412";  //公司注册成功给的
    public static String API_KEY = "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC"; //公司注册成功给的
    public static String UFDOOER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static String NOTIFY_URL = "http://pic.chenjunbo.xin/payment/result"; //支付成功后的回调网址，公司买的
    public static String CREATE_IP = "112.8.128.20";//测试可通过baidu,输入ip查询，支付一定是外网ip

}
