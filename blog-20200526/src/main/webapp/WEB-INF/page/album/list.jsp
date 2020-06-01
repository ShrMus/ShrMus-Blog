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
    <title>相册 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/resource.css" rel="stylesheet" />
</head>
<body>
    <jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>${requestScope.user.nickname}的相册</cite></a>
            </blockquote>
            <div class="blog-main">
                <div class="blog-main">
                    <div class="child-nav shadow">
                        <span class="child-nav-btn child-nav-btn-this">${requestScope.user.nickname}的相册</span>
                    </div>
                    <div class="blog-main-left">
	                    <div class="resource-main">
	                    	<c:forEach var="album" items="${albumList}">
	                        <div class="resource shadow" style="height:240px;position:relative;">
	                            <div class="resource-cover">
	                                <a href="${pageContext.request.contextPath}/album/${album.albumId}">
	                                    <img style="height:200px;" src="${empty album.albumCoverImg?defaultImgUrl:album.albumCoverImg}" alt="${album.albumName}" />
	                                </a>
	                            </div>
	                            <h1 class="resource-title"><a href="${empty album.albumCoverImg?defaultImgUrl:album.albumCoverImg}"></a></h1>
	                            <p class="resource-abstract"></p>
	                            <div class="resource-info" style="position:absolute;bottom:0;">
	                            	<span class="category"><a href="${pageContext.request.contextPath}/album/${album.albumId}"><i class="fa fa-file-photo-o fa-fw"></i>&nbsp;${album.albumName}</a></span>
	                                <span class="author"><i class="fa fa-user fa-fw"></i>${album.blogUser.nickname}</span>
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
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/addui">创建相册</a>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/album/deleteui">删除相册</a>
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
</body>
</html>