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
    <title>文章专栏 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!--本页样式表-->
    <link href="${pageContext.request.contextPath}/css/article.css" rel="stylesheet" />
	<style type="text/css">
		.article-abstract{
			height:51px;
			line-height:30px;
			overflow:hidden; 
			text-overflow:ellipsis;
			display:-webkit-box; 
			-webkit-box-orient:vertical;
			-webkit-line-clamp:2; 
			font-size:16px;
		}
		.article-abstract h1{
			font-size:16px;
		}
		.article-abstract img{
			display:none;
		}
	</style>
</head>
<body>
    <jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>文章专栏</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">全部</span>
                </div>
                <div class="blog-main-left">
                    <div class="shadow" style="text-align:center;font-size:16px;padding:40px 15px;background:#fff;margin-bottom:15px;">
                    <c:if test="${empty articleList}">未搜索到与<span style="color: #FF5722;">${empty keywords?'keywords':keywords}</span>有关的文章，随便看看吧！</c:if>
                    <c:if test="${!empty articleList}">
                    	<c:if test="${empty keywords}">找到<span style="color: #FF5722;">${fn:length(articleList)}</span>篇文章！</c:if>
                    	<c:if test="${!empty keywords}">找到与<span style="color: #FF5722;">${keywords}</span>有关的<span style="color: #FF5722;">${fn:length(articleList)}</span>篇文章！</c:if>
                    </c:if>
                    </div>
                    <c:forEach var="article" items="${articleList}">
                    <div class="article shadow">
                        <div class="article-left">
                            <img src="${pageContext.request.contextPath}/images/cover/TIM截图20180511024658.png" alt="${article.articleTitle}" />
                        </div>
                        <div class="article-right">
                            <div class="article-title">
                                <a href="${pageContext.request.contextPath}/article/search/${article.articleId}">${article.articleTitle}</a>
                            </div>
                            <div class="article-abstract">${article.articleContent}...</div>
                        </div>
                        <div class="clear"></div>
                        <div class="article-footer">
                           <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${article.articleUpdateTime}"/></span>
                            <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${article.blogUser.nickname}</span>
                            <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">${article.blogArticleType.articleTypeName}</a></span>
                            <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;${article.articleCountClick}</span>
                            <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;${fn:length(article.blogArticleCommentList)}</span>
                        </div>
                    </div>
                     </c:forEach>
                </div>
                <div class="blog-main-right">
                    <div class="blog-search">
                        <form class="layui-form" action="${pageContext.request.contextPath}/article/index/search">
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
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/article/addui">写博客</a>
                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/article/user${sessionScope.user.id}">我的博客</a>
	                    <%-- 管理员操作 --%>
                    	<c:if test="${fn:contains(sessionScope.user.userRoleList[0].name,'管理员')}">
	                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/article/index/import">导入索引</a>
	                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/article/verifyui">审核文章</a>
	                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/article/topui">推荐文章</a>
	                    </c:if>
                        <div class="clear"></div>
                    </div>
                    <div class="article-category shadow">
                        <div class="article-category-title">分类导航</div>
                        <c:forEach var="articleType" items="${articleTypeList}">
                        <a href="${pageContext.request.contextPath}/articlebytype/${articleType.articleTypeId}">${articleType.articleTypeName}</a>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                    
                    <div class="blog-module shadow">
                        <div class="blog-module-title">推荐</div>
                        <ul class="fa-ul blog-module-ul">
                        	<c:forEach var="articleByTop" items="${articleListByTop}">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="${pageContext.request.contextPath}/article/search/${articleByTop.articleId}">${articleByTop.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    
                    <div class="blog-module shadow">
                        <div class="blog-module-title">随便看看</div>
                        <ul class="fa-ul blog-module-ul">
                        	<c:forEach var="articleNew" items="${articleListNew}">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="${pageContext.request.contextPath}/article/search/${articleNew.articleId}">${articleNew.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
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
<script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>