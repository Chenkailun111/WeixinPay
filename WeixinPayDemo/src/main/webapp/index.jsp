<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019/3/24
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微信支付</title>
</head>
<body>
        <form action="/payment" method="post">
            <table>
                <tr>
                    <td>商品名称</td>
                    <td>价格</td>
                    <td>数量</td>
                </tr>

                <tr>
                    <td><input type="text" value="Java从入门到放弃" name="name" readonly/></td>
                    <td><input type="text" value="1" name="price" readonly/></td>
                    <td><input type="text" value="1"  name="number"/></td>
                </tr>
            </table>
            <input type="submit" value="支付">
        </form>
</body>
</html>
