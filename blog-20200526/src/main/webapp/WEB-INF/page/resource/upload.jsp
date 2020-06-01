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
    <title>上传资源 - 斑点博客</title>
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
    <link href="${pageContext.request.contextPath}/css/article.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
        	<blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>上传资源</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">上传资源</span>
                </div>
                <div class="blog-main-left">
				<div class="shadow" style="text-align:left;font-size:16px;padding:40px 40px;background:#fff;margin-bottom:15px;">
					<div style="color:red;">您可以上传小于200M的文件</div>
					<form class="layui-form" id="resouce-form" action="${pageContext.request.contextPath}/resource/upload" method="post" enctype="multipart/form-data">
						<table class="layui-table" lay-size="lg" width="100%">
							<tr>
								<td colspan="2" align="center"><input id="fileUpload" type="file" name="file"/></td>
							</tr>
							<tr>
								<td>资源名称</td>
								<td><input class="layui-input" type="text" name="resourceName"></td>
							</tr>
							<tr>
								<td>资源描述</td>
								<td>
								<textarea rows="2" cols="70" name="resourceDescription" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>
								</td>
							</tr>
							<tr>
								<td>选择下载积分</td>
								<td>
									<select name="resourceIntegral" lay-verify="">
										<option value="2">2</option>
										<option value="5">5</option>
										<option value="8">8</option>
										<option value="10">10</option>
										<option value="12">12</option>
										<option value="15">15</option>
										<option value="18">18</option>
										<option value="20">20</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input class="layui-btn" id="submit-button" type="button" value="上传"></td>
							</tr>
						</table>
					</form>
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
$("#fileUpload").on('change', function () {
	var files = $(this)[0].files;
	if(!checkFileSize(files[0])){
		alert("文件不能超过200M！！！");
		$(this).val("");
	}
});
$("#submit-button").click(function(){
	var tag = true;
	// 没有选择文件
	var files = $("#fileUpload")[0].files;
	if(1 > files.length) {
		alert("请选择文件！");
		tag = false;
	} else if(1 == files.length){
		var countFiles = files.length;
		for (var i = 0; i < countFiles; i++) {
			// 如果文件太大
			if(!checkFileSize(files[i])){
				alert("文件不能超过200M！！！");
				tag = false;
			}
		}
	}
	if(tag){
		$("#resouce-form").submit();
	}
});
// 获取文件大小
function checkFileSize(obj){
	var size = obj.size;
	if(size > 209715200){
		return false;
	}
	return true;
}
</script>
</html>