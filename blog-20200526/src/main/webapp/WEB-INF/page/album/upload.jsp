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
    <title>上传照片 - 斑点博客</title>
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
                <a><cite>上传照片</cite></a>
            </blockquote>
            <div class="blog-main">
            	<div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">上传照片</span>
                </div>
				<div class="shadow" style="text-align:left;font-size:16px;padding:40px 240px;background:#fff;margin-bottom:15px;">
					<form class="layui-form" id="album-form" action="${pageContext.request.contextPath}/album/upload" method="post" enctype="multipart/form-data">
						<table>
							<tr>
								<td>选择上传的相册</td>
								<td>
									<select name="albumId" lay-verify="">
										<c:forEach var="album" items="${albumList}">
										<option value="${album.albumId}">${album.albumName}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
						<div style="color:red;">选择图片之后可预览图片,仅支持JPG,JPEG,GIF,PNG格式;文件小于5M</div><br>
						<div style="color:red;">${message}</div>
						<div id="wrapper">
							<input id="fileUpload" class="layui-input" type="file" name="file" multiple /><br />
							<div id="image-holder"> </div>
						</div><br>
						<input id="submit-button" class="layui-btn" type="button" value="上传"/>
					</form>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
$("#submit-button").click(function(){
	var tag = true;
	// 没有选择文件
	var files = $("#fileUpload")[0].files;
	if(1 > files.length) {
		alert("请选择图片.");
		tag = false;
	} else{
		var countFiles = files.length;
		for (var i = 0; i < countFiles; i++) {
			// 如果不是图片
			if(!checkFileExt(files[i])){
				alert("请选择指定格式的图片！！！");
				tag = false;
			}
			// 如果文件太大
			if(!checkFileSize(files[i])){
				alert("文件不能超过5M！！！");
				tag = false;
			}
		}
	}
	if(tag){
		$("#album-form").submit();
	}
});
// 获取文件后缀名
function checkFileExt(obj){
	var upFileName = obj.name;
	var index1=upFileName.lastIndexOf(".");
	var index2=upFileName.length;
	var suffix=upFileName.substring(index1+1,index2);
	var upper = suffix.toUpperCase();
	var regex = new RegExp("PNG|JPG|GIF");
	var result = regex.test(upper);
	return result;
}
// 获取文件大小
function checkFileSize(obj){
	var size = obj.size;
	if(size > 5242880){
		return false;
	}
	return true;
}

$("#fileUpload").on('change', function () {
	   //获取上传文件的数量
	   var countFiles = $(this)[0].files.length;
	 
	   var imgPath = $(this)[0].value;
	   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	   var image_holder = $("#image-holder");
	   image_holder.empty();
	 
	   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	       if (typeof (FileReader) != "undefined") {
	 
	           // 循环所有要上传的图片
	           for (var i = 0; i < countFiles; i++) {
	               var reader = new FileReader();
	               reader.onload = function (e) {
	                   $("<img />", {
	                       "src": e.target.result,
	                           "class": "thumb-image"
	                   }).appendTo(image_holder);
	               }
	 
	               image_holder.show();
	               reader.readAsDataURL($(this)[0].files[i]);
	           }
	 
	       } else {
	           alert("你的浏览器不支持FileReader！");
	       }
	   } else {
	       alert("请选择图像文件。");
	   }
	});
</script>
</html>