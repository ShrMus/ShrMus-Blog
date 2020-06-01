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
    <title>${question.questionTitle} - 问答 - 斑点博客</title>
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
    <!-- 本页样式表 -->
    <%-- <link href="${pageContext.request.contextPath}/css/about.css" rel="stylesheet" /> --%>
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
                <a href="${pageContext.request.contextPath}/question/list" title="问答">问答</a>
                <a><cite>${article.articleTitle}</cite></a>
                <span id="time"></span>
            </blockquote>
            <div class="blog-main">
                <div class="blog-main-left">
                    <!-- 文章内容（使用Kingeditor富文本编辑器发表的） -->
                    <div class="article-detail shadow">
                    	<!--  class="article-detail-title"
                        <div class="article-detail-info">
                        </div>
                    	 -->
                        <div style="font-family:'黑体';font-size:x-large;"><b>${question.questionTitle}</b></div>
                        <div class="article-detail-info">
                            <span>提问时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${question.questionPublishTime}"/></span>
                            <span>提问者：${question.blogUserAuthor.nickname}</span>
                        </div>
                        <div class="article-detail-content">
                        	${question.questionContent}
                            <hr />
                            &nbsp; &nbsp; 出自：斑点博客
                            <p>
                                <br />
                            </p>
                        </div>
                    </div>
                    <!-- 评论区域 -->
                    <div class="blog-module shadow" style="box-shadow: 0 1px 8px #a6a6a6;">
                        <fieldset class="layui-elem-field layui-field-title" style="margin-bottom:0">
                            <legend>来说两句吧</legend>
                            <div class="layui-field-box">
                                <form class="layui-form blog-editor" action="">
                                    <div class="layui-form-item">
                                        <div style="height:200px;">
                                        <textarea id="textarea-content" name="articleCommentContent" style="height:200px;" placeholder="请输入内容" class="layui-textarea layui-hide"></textarea>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <button class="layui-btn question-add-button">回答</button>
                                    </div>
                                </form>
                            </div>
                        </fieldset>
                        <div class="blog-module-title">回答区</div>
                        <input id="questionId-input" type="hidden" name="questionId" value="${question.questionId}"/>
						<input id="userIdReply-input" type="hidden" name="userIdReply" value="0"/>
						<input id="questionPid-input" type="hidden" name="questionPid" value="0"/>
						<input id="questionTitle-input" type="hidden" name="questionTitle" value=""/>
						<input id="questionIntegral-input" type="hidden" name="questionIntegral" value="0"/>
						<input id="questionAccpeted-input" type="hidden" name="questionAccpeted" value="0"/>
						<!-- <textarea id="commentContent-textarea" rows="5" cols="10" style="display:none;"></textarea> -->
                        <ul class="blog-comment">
                        	<c:forEach var="answer" items="${question.questionList}">
							<c:if test="${0 eq answer.userIdReply and 0 ne answer.questionPid}">
							<c:if test="${1 eq answer.questionAccpeted}">
							<div style="color:red;">已采纳</div><br>
	                        <li>
	                            <div class="comment-parent">
									<img src="${answer.blogUserAuthor.icon}" alt="${answer.blogUserAuthor.nickname}" />
									<div class="info">
										<span class="span-questionPid" style="display:none;">${answer.questionId}</span>
										<span class="span-questionId" style="display:none;">${answer.questionId}</span>
										<span class="span-userId" style="display:none;">${answer.blogUserAuthor.id}</span>
										<span class="username">${answer.blogUserAuthor.nickname}</span>
									</div>
									<div class="content">${answer.questionContent}</div>
									<p class="info info-footer"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${answer.questionPublishTime}"/></span>
									<c:if test="${false eq tag}">
									<c:if test="${sessionScope.user.id eq question.userIdAuthor}">
										<a class="btn-reply accpet-span" href="#">采纳</a>
									</c:if>
									</c:if>
									<a class="btn-reply reply-a" href="javascript:;">回复</a>
									<%-- <c:if test="${!empty sessionScope.user}">
									<c:if test="${sessionScope.user.id eq question.blogUserAuthor.id}">
									<a href="#" class="btn-reply a-deletequestion">刪除</a>
									</c:if>
									</c:if> --%>
									</p>
								</div>
	                            <hr />
	                            <c:forEach var="answerChild" items="${answer.questionList}">
	                            <div class="comment-child">
	                                <img src="${answerChild.blogUserAuthor.icon}" alt="${answerChild.blogUserAuthor.nickname}" />
									<div class="info">
										<span class="span-questionPid" style="display:none;">${answer.questionId}</span>
										<span class="span-questionId" style="display:none;">${answerChild.questionId}</span>
										<span class="span-userId" style="display:none;">${answerChild.blogUserAuthor.id}</span>
	                                    <span class="username">${answerChild.blogUserAuthor.nickname}</span>
	                                    <span>回复</span>
	                                    <span class="username">${answerChild.blogUserReply.nickname}</span>
										<span>${answerChild.questionContent}</span>
	                                </div>
	                                <p class="info"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${answerChild.questionPublishTime}"/></span>
	                                <a class="btn-reply reply-a" href="javascript:;">回复</a>
									<%-- <c:if test="${!empty sessionScope.user}">
									<c:if test="${sessionScope.user.id eq question.blogUserAuthor.id}">
									<a href="#" class="btn-reply a-deletequestion">刪除</a>
									</c:if>
									</c:if> --%>
	                                </p>
	                            </div>
	                            </c:forEach>
	                        </li>
							</c:if>
							</c:if>
							</c:forEach>
	                    </ul>
	                    
	                    <ul class="blog-comment">
                        	<c:forEach var="answer" items="${question.questionList}">
							<c:if test="${0 eq answer.userIdReply and 0 ne answer.questionPid}">
							<c:if test="${0 eq answer.questionAccpeted}">
	                        <li>
	                            <div class="comment-parent">
									<img src="${answer.blogUserAuthor.icon}" alt="${answer.blogUserAuthor.nickname}" />
									<div class="info">
										<span class="span-questionPid" style="display:none;">${answer.questionId}</span>
										<span class="span-questionId" style="display:none;">${answer.questionId}</span>
										<span class="span-userId" style="display:none;">${answer.blogUserAuthor.id}</span>
										<span class="username">${answer.blogUserAuthor.nickname}</span>
									</div>
									<div class="content">${answer.questionContent}</div>
									<p class="info info-footer"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${answer.questionPublishTime}"/></span>
									<a class="btn-reply reply-a" href="javascript:;">回复</a>
									<c:if test="${false eq tag}">
									<c:if test="${sessionScope.user.id eq question.userIdAuthor}">
										<a class="btn-reply accpet-span" href="#">采纳</a>
									</c:if>
									</c:if>
									<%-- <c:if test="${!empty sessionScope.user}">
									<c:if test="${sessionScope.user.id eq question.blogUserAuthor.id}">
									<a href="#" class="btn-reply a-deletequestion">刪除</a>
									</c:if>
									</c:if> --%>
									</p>
								</div>
	                            <hr />
	                            <c:forEach var="answerChild" items="${answer.questionList}">
	                            <div class="comment-child">
	                                <img src="${answerChild.blogUserAuthor.icon}" alt="${answerChild.blogUserAuthor.nickname}" />
									<div class="info">
										<span class="span-questionPid" style="display:none;">${answer.questionId}</span>
										<span class="span-questionId" style="display:none;">${answerChild.questionId}</span>
										<span class="span-userId" style="display:none;">${answerChild.blogUserAuthor.id}</span>
	                                    <span class="username">${answerChild.blogUserAuthor.nickname}</span>
	                                    <span>回复</span>
	                                    <span class="username">${answerChild.blogUserReply.nickname}</span>
										<span>${answerChild.questionContent}</span>
	                                </div>
	                                <p class="info"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${answerChild.questionPublishTime}"/></span>
	                                <a class="btn-reply reply-a" href="javascript:;">回复</a>
									<%-- <c:if test="${!empty sessionScope.user}">
									<c:if test="${sessionScope.user.id eq question.blogUserAuthor.id}">
									<a href="#" class="btn-reply a-deletequestion">刪除</a>
									</c:if>
									</c:if> --%>
	                                </p>
	                            </div>
	                            </c:forEach>
	                            <!-- 回复表单默认隐藏 -->
	                            <div class="replycontainer layui-hide">
	                                <form class="layui-form" action="">
	                                    <div class="layui-form-item">
	                                        <textarea name="replyContent" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" style="min-height:80px;"></textarea>
	                                    </div>
	                                    <div class="layui-form-item">
	                                        <button class="layui-btn layui-btn-mini" lay-submit="formReply" lay-filter="formReply">提交</button>
	                                    </div>
	                                </form>
	                            </div>
	                        </li>
							</c:if>
							</c:if>
							</c:forEach>
	                    </ul>
                    </div>
                </div>
                <div class="blog-main-right">
                    <!--右边悬浮 平板或手机设备显示-->
                    <div class="category-toggle"><i class="fa fa-chevron-left"></i></div><!--这个div位置不能改，否则需要添加一个div来代替它或者修改样式表-->
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/wangEditor.js"></script>
<script type="text/javascript">
	var editor = new wangEditor('textarea-content');
	
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
</script>
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
	$(".question-add-button").click(function(){
		var userIdReply = $("#userIdReply-input").val();
		var questionPid = $("#questionPid-input").val();
		if(0 == questionPid){
			$("#questionPid-input").val($("#questionId-input").val());
		}
		questionPid = $("#questionPid-input").val();
		var questionTitle = $("#questionTitle-input").val();
		var questionIntegral = $("#questionIntegral-input").val();
		var questionAccpeted = $("#questionAccpeted-input").val();
		var questionContent = $("#textarea-content").val();
		
		var forwardUrl = "${pageContext.request.contextPath}/question/add";
		var data = {"questionPid":questionPid,
				"userIdReply":userIdReply,
				"questionTitle":questionTitle,
				"questionIntegral":questionIntegral,
				"questionAccpeted":questionAccpeted,
				"questionContent":questionContent};
		$.post(forwardUrl,data,function(){
			window.location.reload();
			return;
		});
	});
	// 点击回复
	$(".reply-a").click(function(){
		$(".question-add-button").html("添加回复");
		$("#userIdReply-input").val($(this).parent().siblings("div .info").children(".span-userId").html());
		var questionPid = $(this).parent().siblings("div .info").children(".span-questionPid").html();
		$("#questionPid-input").val(questionPid);
		$("#textarea-content").focus();
	});
	
	$(".accpet-span").click(function(){
		if(confirm("您确定要采纳这个回答吗？")){
			var questionId = $("#questionId-input").val();
			var answerId = $(this).parent().siblings("div .info").children(".span-questionId").html();
			var userIdReply = $(this).parent().siblings("div .info").children(".span-userId").html();
			var forwardUrl = "${pageContext.request.contextPath}/question/accpet";
			var data = {"questionId":questionId, //
					"answerId":answerId, //
					"userIdReply":userIdReply};
			$.post(forwardUrl,data,function(){
				window.location.reload();
				return;
			});
		}
	});
	// 点击删除
	/* $(".a-deletequestion").click(function(){
		var questionId = $(this).parent().siblings("div .info").children(".span-questionId").html();
		var articleId = $("#articleId-input").val();
		var forwardUrl = "${pageContext.request.contextPath}/articlecomment/delete";
		var data = {"articleId":articleId,
				"articleCommentId":commentId};
		$.post(forwardUrl,data,function(){
			window.location.reload();
			return;
		});
	}); */


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