<%--
  Created by IntelliJ IDEA.
  User: joizhang
  Date: 2018/5/20
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
    <title>Login Demo </title>
</head>

<body id="main">
    <form id="form1" action="<%=request.getContextPath()%>/login" method="post">
        <table style="width:300px">
            <tr>
                <td colspan="2">登录窗口</td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" size="10" value="${username}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" size="10"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="display:${empty message ? 'none': 'block'};color:red">${message}</div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录" id="login">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
