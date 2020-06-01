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
    <title>留言- 斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/about.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/dist/css/wangEditor.css"
	rel="stylesheet" type="text/css">
</head>
<body>
    <jsp:include page="/banner.jsp"/>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="${pageContext.request.contextPath}/main" title="首页">首页</a>
                <a><cite>留言</cite></a>
            </blockquote>
            <div class="blog-main">
                <div class="layui-tab layui-tab-brief shadow" lay-filter="tabAbout">
                    <ul class="layui-tab-title">
                        <li lay-id="1" class="layui-this">留言墙</li>
                    </ul>
                    <div class="layui-tab-content">
                    	<div class="layui-tab-item">
                            <div class="aboutinfo">
                                <div class="aboutinfo-figure">
                                    <img src="${pageContext.request.contextPath}/images/messagewall.png" alt="留言墙" />
                                </div>
                                <p class="aboutinfo-nickname">留言墙</p>
                                <p class="aboutinfo-introduce">本页面可留言、吐槽。欢迎灌水，杜绝广告！</p>
                                <p class="aboutinfo-location">
                                    <i class="fa fa-clock-o"></i>&nbsp;<span id="time"></span>
                                </p>
                                <hr />
                                <div class="aboutinfo-contact">
                                    <p style="font-size:2em;">沟通交流，拉近你我！</p>
                                </div>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>Leave a message</legend>
                                    <div class="layui-field-box">
                                        <div class="leavemessage" style="text-align:initial">
                                        	<input id="userId-input" type="hidden" name="articleId" value="${userId}"/>
											<input id="isreply-input" type="hidden" name="articleCommmentIsreply" value="0"/>
											<input id="userIdAuthor-input" type="hidden" value="${sessionScope.user.id}"/>
											<input id="userIdReply-input" type="hidden" name="userIdReply" value="0"/>
											<input id="messagePid-input" type="hidden" name="messagePid" value="0"/>
                                                <div class="layui-form-item">
                                                    <div style="height:200px;">
			                                        <textarea id="textarea-message" name="messageContent" style="height:200px;" placeholder="请输入内容" class="layui-textarea layui-hide"></textarea>
			                                        <button class="layui-btn layui-btn-primary message-add-button">提交留言</button>
			                                        </div>
                                                </div>
                                                <div class="layui-form-item">
                                                    <!-- <button class="layui-btn" lay-submit="formLeaveMessage" lay-filter="formLeaveMessage">提交留言</button> -->
                                                </div>
                                            <ul class="blog-comment" style="margin-top:150px;">
                                            	<c:forEach var="message" items="${messageList}">
												<c:if test="${0 eq message.userIdReply}">
                                                <li>
                                                    <div class="comment-parent">
                                                        <img src="${message.blogUserAuthor.icon}" alt="${message.blogUserAuthor.nickname}" />
                                                        <div class="info">
                                                        	<span class="span-messagePid" style="display:none;">${message.messageId}</span>
															<span class="span-messageId" style="display:none;">${message.messageId}</span>
															<span class="span-userId" style="display:none;">${message.blogUserAuthor.id}</span>
                                                            <span class="username">${message.blogUserAuthor.nickname}</span>
                                                        </div>
                                                        <div class="content">${message.messageContent}</div>
                                                        <p class="info info-footer"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${message.messagePublishTime}"/></span>
                                                        <a class="btn-reply reply-a" href="javascript:;">回复</a>
                                                        <c:if test="${!empty sessionScope.user}">
														<c:if test="${sessionScope.user.id eq userId}">
														<a href="#" class="btn-reply a-deletemessage">刪除</a>
														</c:if>
														</c:if>
														</p>
                                                    </div>
                                                    <hr />
                                                    <c:forEach var="messageChild" items="${message.messagesList}">
                                                    <div class="comment-child">
                                                        <img src="${messageChild.blogUserAuthor.icon}" alt="${messageChild.blogUserAuthor.nickname}" />
                                                        <div class="info">
                                                        	<span class="span-messagePid" style="display:none;">${message.messageId}</span>
															<span class="span-messageId" style="display:none;">${messageChild.messageId}</span>
															<span class="span-userId" style="display:none;">${messageChild.blogUserAuthor.id}</span>
                                                            <span class="username">${messageChild.blogUserAuthor.nickname}</span>
                                                            <span>回复</span>
	                                    					<span class="username">${messageChild.blogUserReply.nickname}</span>
                                                            <span>${messageChild.messageContent}</span>
                                                        </div>
                                                        <p class="info"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${messageChild.messagePublishTime}"/></span>
                                                        <a class="btn-reply reply-a" href="javascript:;">回复</a>
                                                        <c:if test="${!empty sessionScope.user}">
														<c:if test="${sessionScope.user.id eq userId}">
														<a href="#" class="btn-reply a-deletemessage">刪除</a>
														</c:if>
														</c:if>
                                                        </p>
                                                    </div>
                                                    </c:forEach>
                                                    <!-- 回复表单默认隐藏 -->
                                                    <!-- <div class="replycontainer layui-hide">
                                                        <form class="layui-form" action="">
                                                            <div class="layui-form-item">
                                                                <textarea name="replyContent" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" style="min-height:80px;"></textarea>
                                                            </div>
                                                            <div class="layui-form-item">
                                                                <button class="layui-btn layui-btn-mini" lay-submit="formReply" lay-filter="formReply">提交</button>
                                                            </div>
                                                        </form>
                                                    </div> -->
                                                </li>
                                                </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </fieldset>
                            </div>
                        </div><!--留言墙End-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/dist/js/wangEditor.js"></script>
<!-- layui.js -->
<script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
<!-- 全局脚本 -->
<script src="${pageContext.request.contextPath}/js/global.js"></script>
<!-- 本页脚本 -->
<script src="${pageContext.request.contextPath}/js/about.js"></script>
<script type="text/javascript">
    var editor = new wangEditor('textarea-message');
    
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
    
 	// 点击添加留言按钮
	$(".message-add-button").click(function(){
		var userId = $("#userId-input").val();
		var messagePid = $("#messagePid-input").val();
		var messageIsreply = $("#isreply-input").val();
		var userIdAuthor = $("#userIdAuthor-input").val();
		var userIdReply = $("#userIdReply-input").val();
		var messageContent = $("#textarea-message").val();
		
		var forwardUrl = "${pageContext.request.contextPath}/message/add";
		var data = {"userId":userId,
				"messagePid":messagePid,
				"messageIsreply":messageIsreply,
				"userIdAuthor":userIdAuthor,
				"userIdReply":userIdReply,
				"messageContent":messageContent};
		$.post(forwardUrl,data,function(){
			window.location.reload();
			return;
		});
	});
	// 点击回复
	$(".reply-a").click(function(){
		$(".message-add-button").html("回复");
		$("#isreply-input").val(1);
		var userReply = $(this).parent().siblings("div .info").children(".span-userId").html()
		$("#userIdReply-input").val(userReply);
		var messagePid = $(this).parent().siblings("div .info").children(".span-messagePid").html();
		$("#messagePid-input").val(messagePid);
		console.log(userReply+" "+messagePid);
		$("#textarea-message").focus();
	});
	// 点击删除
	$(".a-deletemessage").click(function(){
		var messageId = $(this).parent().siblings("div .info").children(".span-messageId").html();
		var userId = $("#userId-input").val();
		var forwardUrl = "${pageContext.request.contextPath}/message/delete";
		var data = {"messageId":messageId,
				"userId":userId};
		$.post(forwardUrl,data,function(){
			window.location.reload();
			return;
		});
	});
</script>
</html>