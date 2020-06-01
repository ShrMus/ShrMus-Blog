<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>注册 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- canvas -->
        <canvas id="canvas-banner" style="background: #393D49;"></canvas>
        <!--为了及时效果需要立即设置canvas宽高，否则就在home.js中设置-->
        <script type="text/javascript">
            var canvas = document.getElementById('canvas-banner');
            canvas.width = window.document.body.clientWidth - 10;//减去滚动条的宽度
            if (screen.width >= 992) {
                canvas.height = window.innerHeight * 1 / 3;
            } else {
                canvas.height = window.innerHeight * 2 / 7;
            }
        </script>
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">
                        <span style="color: #009688">斑点博客，作者Shr</span>
                        <span style="color: #009688">与未知的相遇，七分欢喜三分孤寂。</span>
                    </div>
                </div>
                <div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">注册</span>
                </div>
				<div class="shadow" style="text-align:center;font-size:16px;padding:40px 240px;background:#fff;margin-bottom:15px;">
                	<form class="layui-form" action="${pageContext.request.contextPath}/user/reg" method="post">
						<table class="layui-table" lay-size="lg" width="100%">
							<tr>
								<td>用户名：</td>
								<td><input class="layui-input" type="text" name="username" placeholder="请输入用户名" value="${regUser.username}"><span style="color:red;">${requestScope.message}</span></td>
							</tr>
							<tr>
								<td>密　码：</td>
								<td><input class="layui-input" type="password" name="password" placeholder="请输入密码" value="${regUser.password}"></td>
							</tr>
							<tr>
								<td>再次确认密码：</td>
								<td><input class="layui-input" type="password" name="password" placeholder="请再次输入密码" value="${regUser.password}"></td>
							</tr>
							<tr>
								<td>昵　称：</td>
								<td><input class="layui-input" type="text" name="nickname" placeholder="请输入昵称" value="${regUser.nickname}"></td>
							</tr>
							<tr>
								<td>性　别：</td>
								<td>
								<select name="gender" lay-verify="">
									<option value="1">男</option>
									<option value="0">女</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>手　机：</td>
								<td><input class="layui-input" type="text" name="phone" placeholder="请输入手机号码" value="${regUser.phone}"></td>
							</tr>
							<tr>
								<td>邮　箱：</td>
								<td><input class="layui-input" type="text" name="email" placeholder="请输入邮箱" value="${regUser.email}"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input class="layui-btn layui-btn-primary" type="submit" value="注册"></td>
							</tr>
						</table>
					</form>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</body>
<!-- layui.js -->
<script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
<!-- 全局脚本 -->
<script src="${pageContext.request.contextPath}/js/global.js"></script>
<!-- 本页脚本 -->
<script src="${pageContext.request.contextPath}/js/home.js"></script>
</html>