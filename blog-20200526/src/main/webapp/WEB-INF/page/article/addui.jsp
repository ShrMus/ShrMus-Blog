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
    <title>写博客 - 斑点博客</title>
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
<link href="${pageContext.request.contextPath}/dist/css/wangEditor.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
        	<blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>写博客</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">写博客</span>
                </div>
				<div class="shadow" style="text-align:left;font-size:16px;padding:40px 140px;background:#fff;margin-bottom:15px;">
					<form id="form-article" class="layui-form" action="${pageContext.request.contextPath}/article/add" method="post">
						<input class="layui-input" type="text" name="articleTitle" value="${article.articleTitle}" placeholder="输入博客标题" required="required" lay-verify="required"/>
						<div style="width: 100%">
							<!--用当前元素来控制高度-->
							<textarea id="textarea-article" name="articleContent" style="height: 400px; max-height: 500px;">${article.articleContent}</textarea>
						</div>
						<i class="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #1E9FFF;"></i>博客类型：
						<select name="articleTypeId" lay-verify="">
						<c:forEach var="articleType" items="${articleTypeList}">
							<option value="${articleType.articleTypeId}">${articleType.articleTypeName}</option>
						</c:forEach>
						</select>
					</form>
					<div><span style="color:red;">${message}</span></div>
					<button class="layui-btn layui-btn-primary" id="submit1">提交</button>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</body><!--引入jquery和wangEditor.js-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/wangEditor.js"></script>
<script type="text/javascript">
	var editor = new wangEditor('textarea-article');
	
	// 下面两个配置，使用其中一个即可显示“上传图片”的tab。但是两者不要同时使用！！！
    // editor.config.uploadImgShowBase64 = true;   // 使用 base64 保存图片
    // editor.config.uploadImgServer = 'http://localhost:8080/blog/pic/upload'  // 上传图片到服务器
    // editor.config.uploadFileName = 'pictureName';
    // editor.config.showLinkImg = true;
    
	editor.config.uploadImgFileName = 'pictureName';
	editor.config.uploadImgUrl = '${pageContext.request.contextPath}/article/uploadpicture';
	// 隐藏掉插入网络图片功能。该配置，只有在你正确配置了图片上传功能之后才可用。
	editor.config.hideLinkImg = false;

	editor.create();
	
    document.getElementById('submit1').addEventListener('click', function () {
        // 读取 html
        var content = editor.$txt.html();
        $("#textarea-article").html(content);
        // var textareaElement = document.getElementById('textarea-article');
        // textareaElement.innerHTML = content;
        var formElement = document.getElementById('form-article');
        formElement.submit();
    }, false)
</script>
<!-- layui.js -->
<script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
<!-- 全局脚本 -->
<script src="${pageContext.request.contextPath}/js/global.js"></script>
<!-- 本页脚本 -->
<script src="${pageContext.request.contextPath}/js/home.js"></script>
<script type="text/javascript">
</script>
</html>