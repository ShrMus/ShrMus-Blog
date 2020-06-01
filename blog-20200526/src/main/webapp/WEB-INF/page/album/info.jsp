<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>查看相册 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/resource.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/jquery.magnify.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/fonts/fontawesome-webfont.svg" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>查看相册</cite></a>
            </blockquote>
            <div class="blog-main">
                <div class="blog-main">
                    <div class="child-nav shadow">
                    	<input id="input-albumId" type="hidden" value="${album.albumId}">
                        <span class="child-nav-btn child-nav-btn-this">${album.albumName} 创建于 <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${album.albumCreateTime}"/></span>
                    </div>
                    <div class="blog-main-left">
	                    <div class="resource-main">
	                    	<c:forEach var="picture" items="${pictureList}">
	                        <div class="resource shadow" style="height:244px;position:relative;">
	                            <div class="resource-cover">
	                                <a data-magnify="gallery" href="${picture.pictureUrl}">
	                                    <img style="height:200px;" src="${picture.pictureUrl}" alt="${picture.pictureName}" />
	                                </a>
	                            </div>
	                            <h1 class="resource-title"><a href="${picture.pictureUrl}"></a></h1>
	                            <p class="resource-abstract"></p>
	                            <div class="resource-info" style="position:absolute;bottom:0;">
	                            	<span class="category"><a data-magnify="gallery" href="${picture.pictureUrl}"><i class="fa fa-file-photo-o fa-fw"></i>&nbsp;${picture.pictureName}</a></span>
	                                <div class="clear"></div>
	                            </div>
	                            <%-- <div class="resource-footer">
	                                <a class="layui-btn layui-btn-small layui-btn-primary" href="${pageContext.request.contextPath}/album/${album.albumId}" target="_blank"><i class="fa fa-eye fa-fw"></i>查看</a>
	                            </div> --%>
	                        </div>
	                        </c:forEach>
	                        <!-- 清除浮动 -->
	                        <div class="clear"></div>
	                    </div>
	                </div>
	                <div class="blog-main-right">
	                	<div class="article-category shadow">
                        <div class="article-category-title">用户操作</div>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/uploadui">上传照片</a>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/coverimgui/${album.albumId}">设置封面</a>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/updateui/${album.albumId}">修改相册</a>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/picture/deleteui/${album.albumId}">批量删除</a>
	                    <%-- 管理员操作 --%>
                        <div class="clear"></div>
                    </div>
	                </div>
                </div>
            </div>
        </div>
    </div>
    <!-- layui.js -->
    <script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${pageContext.request.contextPath}/js/global.js"></script>
    <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.magnify.min.js"></script>
</body>
</html>