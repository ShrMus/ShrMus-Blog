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
    <title>文章类型 - 斑点博客</title>
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
</head>
<body>
	<jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
        	<blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>文章类型</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">查看</span>
                </div>
				<div class="shadow" style="text-align:center;font-size:16px;padding:40px 240px;background:#fff;margin-bottom:15px;">
					<button class="layui-btn" onclick="addArticleType()">添加</button>
					<table class="layui-table" lay-size="lg" width="100%">
						<thead>
							<tr>
								<th>ID</th>
								<th>类型名称</th>
								<th>类型描述</th>
								<th>操作</th>
							</tr> 
						</thead>
						<tbody>
							<c:forEach var="articleType" items="${articleTypeList}">
							<tr>
								<td class="td-articleTypeId">${articleType.articleTypeId}</td>
								<td>${articleType.articleTypeName}</td>
								<td>${articleType.articleTypeDescription}</td>
								<td><button class="layui-btn" onclick="updateArticleType(this);">修改</button></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
                </div>
                <div class="clear"></div>
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
<script type="text/javascript">
	function addArticleType(){
		var url = "${pageContext.request.contextPath}/articletype/addui";
		window.location.href = url;
	}
	function updateArticleType(obj){
		var articleTypeId = $(obj).parent().siblings(".td-articleTypeId").html();
		var url = "${pageContext.request.contextPath}/articletype/updateui/"+articleTypeId;
		window.location.href = url;
	}
</script>
</html>