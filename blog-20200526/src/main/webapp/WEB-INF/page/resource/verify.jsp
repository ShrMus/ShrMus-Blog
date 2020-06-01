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
    <title>审核资源 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!--本页样式表-->
    <link href="${pageContext.request.contextPath}/css/article.css" rel="stylesheet" />
</head>
<body>
    <jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>审核资源</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">审核资源</span>
                </div>
                <div class="blog-main-left">
                    <div class="shadow" style="text-align:center;font-size:16px;padding:40px 15px;background:#fff;margin-bottom:15px;">
                        <c:if test="${empty resourceList}">未搜索到需要审核的资源！</c:if>
                    	<c:if test="${!empty resourceList}">
                    	找到<span style="color: #FF5722;">${fn:length(resourceList)}</span>个需要审核的资源！
                    	</c:if>
                    </div>
                    <c:forEach var="resource" items="${resourceList}">
                    <div class="article shadow">
                        <%-- <div class="article-left">
                            <img src="${pageContext.request.contextPath}/images/cover/TIM截图20180511024658.png" alt="${article.articleTitle}" />
                            <div style="font-size:xx-large;color:red;"><b>悬赏${question.questionIntegral}</b></div>
                        </div> --%>
                        <div class="article-right" style="width:100%;">
                            <div class="article-title">
                                <a href="${pageContext.request.contextPath}/resource/${resource.resourceId}">${resource.resourceName}</a>
                            </div>
                            <div class="article-abstract">${resource.resourceDescription}...</div>
                        </div>
                        <div class="clear"></div>
                        <div class="article-footer">
                           <span>上传时间：<i class="fa fa-clock-o"></i>&nbsp;&nbsp;<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${resource.resourceUploadTime}"/></span>
                            <span class="article-author">上传人：<i class="fa fa-user"></i>&nbsp;&nbsp;${resource.blogUser.nickname}</span>
                            <%-- <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">${article.blogArticleType.articleTypeName}</a></span> --%>
                            <span class="span-resourceId" style="display:none;">${resource.resourceId}</span>
                            <span><a class="a-pass" href="">通过</a></span>
                            <span><a class="a-nopass" href="">不通过</a></span>
                            <span class="article-viewinfo"><i class="fa fa-download"></i>&nbsp;<a href="#">下载积分：${resource.resourceIntegral}</a>&nbsp;&nbsp;&nbsp;下载次数：${resource.resourceDownloadCount}</span>
                        </div>
                    </div>
                     </c:forEach>
                </div>
                <div class="blog-main-right">
                    <div class="blog-search">
                        <form class="layui-form" action="${pageContext.request.contextPath}/resource/index/search">
                            <div class="layui-form-item">
                                <div class="search-keywords  shadow">
                                    <input type="text" name="keywords" value="${keywords}" lay-verify="required" placeholder="输入关键词搜索" autocomplete="off" class="layui-input">
                                </div>
                                <div class="search-submit  shadow">
                                    <a class="search-btn" lay-submit="formSearch" lay-filter="formSearch"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="article-category shadow">
                        <div class="article-category-title">用户操作</div>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/resource/uploadui">上传资源</a>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/resource/user${sessionScope.user.id}">我的资源</a>
	                    <%-- 管理员操作 --%>
                    	<c:if test="${fn:contains(sessionScope.user.userRoleList[0].name,'管理员')}">
	                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/resource/verifyui">审核资源</a>
	                    </c:if>
                        <div class="clear"></div>
                    </div>
                    <!--右边悬浮 平板或手机设备显示-->
                    <div class="category-toggle"><i class="fa fa-chevron-left"></i></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <!-- layui.js -->
    <script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${pageContext.request.contextPath}/js/global.js"></script>
</body>
<script type="text/javascript">
$(".a-pass").click(function(){
		var resourceId = $(this).parent().siblings(".span-resourceId").html();
		var url = "${pageContext.request.contextPath}/resource/verify";
		var data = {"resourceId":resourceId,"resourceIspass":1};
		$.post(url,data,function(){
			window.location.reload();
		});
	});
	$(".a-nopass").click(function(){
		var resourceId = $(this).parent().siblings(".span-resourceId").html();
		var url = "${pageContext.request.contextPath}/resource/verify";
		var data = {"resourceId":resourceId,"resourceIspass":0};
		$.post(url,data,function(){
			window.location.reload();
		});
	});
</script>
</html>