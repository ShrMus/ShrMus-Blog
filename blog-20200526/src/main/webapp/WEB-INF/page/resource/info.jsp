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
    <title>${resource.resourceName} - 资源分享 - 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 比较好用的代码着色插件 -->
    <link href="${pageContext.request.contextPath}/css/prettify.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/detail.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/article.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <%-- <link href="${pageContext.request.contextPath}/css/about.css" rel="stylesheet" /> --%>
</head>
<body>
    <jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a href="${pageContext.request.contextPath}/article/list" title="资源分享">资源分享</a>
                <a><cite>${article.articleTitle}</cite></a>
                <span id="time"></span>
            </blockquote>
            <div class="blog-main">
                <div class="blog-main-left">
                    <div class="article-detail shadow">
                        <div style="font-family:'黑体';font-size:x-large;"><b>${resource.resourceName}</b></div>
                        <div class="article-detail-info">
                            <span>上传时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${resource.resourceUploadTime}"/></span>
                            <span>上传者：${resource.blogUser.nickname}</span>
                            <span>文件大小：${resource.resourceSize}B</span>
                            <span>下载积分：${resource.resourceIntegral}</span>
                            <span>下载次数：${resource.resourceDownloadCount}</span>
                        </div>
                        <div class="article-detail-content">
                        	${resource.resourceDescription}<br><br>
                        	<a class="layui-btn" href="${pageContext.request.contextPath}/resource/download/${resource.resourceId}">点此下载</a>
							<span style="color:red;">${message}</span>
                            <hr />
                            &nbsp; &nbsp; 出自：斑点博客
                            <p>
                                <br />
                            </p>
                        </div>
                    </div>
                    </div>
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
	                        <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath}/resource/index/import">导入索引</a>
	                    </c:if>
                        <div class="clear"></div>
                    </div>
                    <!--右边悬浮 平板或手机设备显示-->
                    <div class="category-toggle"><i class="fa fa-chevron-left"></i></div><!--这个div位置不能改，否则需要添加一个div来代替它或者修改样式表-->
                </div>
                <div class="clear"></div>
            </div>
        </div>
</body>
<script src="${pageContext.request.contextPath}/js/about.js"></script>
<!-- layui.js -->
<script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
<!-- 自定义全局脚本 -->
<script src="${pageContext.request.contextPath}/js/global.js"></script>
<!-- 比较好用的代码着色插件 -->
<script src="${pageContext.request.contextPath}/js/prettify.js"></script>
<!-- 本页脚本 -->
<script src="${pageContext.request.contextPath}/js/detail.js"></script>
<!-- 本页脚本 -->
<script type="text/javascript">
function btnReplyClick(elem) {
    var $ = layui.jquery;
    $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
    if ($(elem).text() == '回复') {
        $(elem).text('收起')
    } else {
        $(elem).text('回复')
    }
}
systemTime();

function systemTime() {
    //获取系统时间。
    var dateTime = new Date();
    var year = dateTime.getFullYear();
    var month = dateTime.getMonth() + 1;
    var day = dateTime.getDate();
    var hh = dateTime.getHours();
    var mm = dateTime.getMinutes();
    var ss = dateTime.getSeconds();

    //分秒时间是一位数字，在数字前补0。
    mm = extra(mm);
    ss = extra(ss);

    //将时间显示到ID为time的位置，时间格式形如：19:18:02
    document.getElementById("time").innerHTML = year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
    //每隔1000ms执行方法systemTime()。
    setTimeout("systemTime()", 1000);
}
</script>
</html>