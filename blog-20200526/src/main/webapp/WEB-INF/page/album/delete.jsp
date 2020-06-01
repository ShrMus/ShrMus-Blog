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
    <title>删除相册 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/about.css" rel="stylesheet" />
    <!-- 查看照片 -->
<link href="${pageContext.request.contextPath}/css/jquery.magnify.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/fonts/fontawesome-webfont.svg" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
        	<blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>删除相册</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">删除相册</span>
                </div>
				<div class="blog-main-left">
					<div class="shadow" style="text-align:left;font-size:16px;padding:40px 40px;background:#fff;margin-bottom:15px;">
						<div style="color:red;">删除相册会把相册里的照片都删除，谨慎操作！</div>
						<input id="input-userId" type="hidden" value="${sessionScope.user.id}"/>
						<table class="layui-table" lay-size="lg" width="100%"">
							<c:forEach var="album" items="${albumList}">
							<tr>
								<td>
									<input class="input-albumId" type="hidden" value="${album.albumId}"/>
									<input class="input-radio layui-anim layui-icon layui-anim-scaleSpring" name="input-coverImg" type="radio">
								</td>
								<td>
									<a data-magnify="gallery" href="${album.albumCoverImg}">
									<img src="${album.albumCoverImg}" height="140px" width="140px"/>
									</a>
									${album.albumName}
								</td>
							</tr>
							</c:forEach>
						</table>
						<input class="input-coverImg layui-btn" type="button" value="删除">
	                </div>
				</div>
				
				<div class="blog-main-right">
					<div class="article-category shadow">
						<div class="article-category-title">用户操作</div>
						<a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/uploadui">上传照片</a>
						<a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/coverimgui/${album.albumId}">设置封面</a>
						<a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/picture/deleteui/${album.albumId}">批量删除</a>
						<a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/updateui/${album.albumId}">修改相册</a>
						<%-- 管理员操作 --%>
					<div class="clear"></div>
				</div>
            </div>
        </div>
    </div>
    </div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
<!-- layui.js -->
<script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
<!-- 全局脚本 -->
<script src="${pageContext.request.contextPath}/js/global.js"></script>
<!-- 本页脚本 -->
<script src="${pageContext.request.contextPath}/js/home.js"></script>
    <!-- 全局脚本 -->
    <script src="${pageContext.request.contextPath}/js/global.js"></script>
    <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.magnify.min.js"></script>
<script type="text/javascript">
$(".input-coverImg").click(function(){
	var userId = $("#input-userId").val();
	var albumId = $(".input-radio:checked").siblings(".input-albumId").val();
	var url = "${pageContext.request.contextPath}/album/delete";
	var data = {"albumId":albumId};
	$.post(url,data,function(){
		window.location.href = "${pageContext.request.contextPath}/album/user"+userId;
	});
});
</script>
</html>