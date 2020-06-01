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
    <title>${article.articleTitle} - 文章专栏 - 斑点博客</title>
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
                <a href="${pageContext.request.contextPath}/article/list" title="文章专栏">文章专栏</a>
                <a><cite>${article.articleTitle}</cite></a>
                <a style="position:absolute;margin-right:0px;"><span id="time"></span></a>
            </blockquote>
            <div class="blog-main">
                <div class="blog-main-left">
                    <!-- 文章内容（使用Kingeditor富文本编辑器发表的） -->
                    <div class="article-detail shadow">
                        <div class="article-detail-title">${article.articleTitle}</div>
                        <div class="article-detail-info">
                            <span>编辑时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${article.articleUpdateTime}"/></span>
                            <span>作者：${article.blogUser.nickname}</span>
                            <span>浏览量：${article.articleCountClick}</span>
                        </div>
                        <div class="article-detail-content">
                        	${article.articleContent}
                            <hr />
                            &nbsp; &nbsp; 出自：斑点博客
                            <p>
                                &nbsp; &nbsp; 转载请注明出处！
                            </p>
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
                                        <textarea id="textarea-articleComment" name="articleCommentContent" style="height:200px;" placeholder="请输入内容" class="layui-textarea layui-hide"></textarea>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <button class="articlecomment-add-button layui-btn layui-btn-primary">提交评论</button>
                                    </div>
                                </form>
                            </div>
                        </fieldset>
                        <div class="blog-module-title">最新评论</div>
                        <input id="articleId-input" type="hidden" name="articleId" value="${article.articleId}"/>
						<input id="isreply-input" type="hidden" name="articleCommmentIsreply" value="0"/>
						<input id="userIdAuthor-input" type="hidden" value="${sessionScope.user.id}"/>
						<input id="userIdReply-input" type="hidden" name="userIdReply" value="0"/>
						<input id="commentPid-input" type="hidden" name="articleCommentPid" value="0"/>
						<!-- <textarea id="commentContent-textarea" rows="5" cols="10" style="display:none;"></textarea> -->
                        <ul class="blog-comment">
                        	<c:forEach var="blogArticleComment" items="${article.blogArticleCommentList}">
							<c:if test="${article.articleId eq blogArticleComment.articleId}">
							<c:if test="${blogArticleComment.articleCommentPid eq 0}">
	                        <li>
	                            <div class="comment-parent">
									<img src="${blogArticleComment.blogUserAuthor.icon}" alt="${blogArticleComment.blogUserAuthor.nickname}" />
									<div class="info">
										<span class="span-commentPid" style="display:none;">${blogArticleComment.articleCommentId}</span>
										<span class="span-commentId" style="display:none;">${blogArticleComment.articleCommentId}</span>
										<span class="span-userId" style="display:none;">${blogArticleComment.blogUserAuthor.id}</span>
										<span class="username">${blogArticleComment.blogUserAuthor.nickname}</span>
									</div>
									<div class="content">${blogArticleComment.articleCommentContent}</div>
									<p class="info info-footer"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${blogArticleComment.articleCommentPublishTime}"/></span>
									<a class="btn-reply reply-a" href="javascript:;">回复</a>
									<c:if test="${!empty sessionScope.user}">
									<c:if test="${sessionScope.user.id eq article.blogUser.id}">
									<a href="#" class="btn-reply a-deletemessage">刪除</a>
									</c:if>
									</c:if>
									</p>
								</div>
	                            <hr />
	                            <c:forEach var="blogArticleCommentChild" items="${blogArticleComment.blogArticleCommentList}">
	                            <div class="comment-child">
	                                <img src="${blogArticleCommentChild.blogUserAuthor.icon}" alt="${blogArticleCommentChild.blogUserAuthor.nickname}" />
									<div class="info">
										<span class="span-commentPid" style="display:none;">${blogArticleComment.articleCommentId}</span>
										<span class="span-commentId" style="display:none;">${blogArticleCommentChild.articleCommentId}</span>
										<span class="span-userId" style="display:none;">${blogArticleComment.blogUserAuthor.id}</span>
	                                    <span class="username">${blogArticleCommentChild.blogUserAuthor.nickname}</span>
	                                    <span>回复</span>
	                                    <span class="username">${blogArticleCommentChild.blogUserReply.nickname}</span>
										<span>${blogArticleCommentChild.articleCommentContent}</span>
	                                </div>
	                                <p class="info"><span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${blogArticleCommentChild.articleCommentPublishTime}"/></span>
	                                	<a class="btn-reply reply-a" href="javascript:;">回复</a>
										<c:if test="${!empty sessionScope.user}">
										<c:if test="${sessionScope.user.id eq article.blogUser.id}">
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
							</c:if>
							</c:forEach>
	                    </ul>
                    </div>
                </div>
                <div class="blog-main-right">
                    <!--右边悬浮 平板或手机设备显示-->
                    <div class="category-toggle"><i class="fa fa-chevron-left"></i></div><!--这个div位置不能改，否则需要添加一个div来代替它或者修改样式表-->
                    <div class="article-category shadow">
                        <div class="article-category-title">分类导航</div>
                        <c:forEach var="articleType" items="${articleTypeList}">
                        <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">${articleType.articleTypeName}</a>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                    <%--
                    <div class="blog-module shadow">
                        <div class="blog-module-title">相似文章</div>
                        <ul class="fa-ul blog-module-ul">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">基于laypage的layui扩展模块（pagesize.js）！</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">基于laypage的layui扩展模块（pagesize.js）！</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">基于laypage的layui扩展模块（pagesize.js）！</a></li>
                        </ul>
                    </div>
                     --%>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">随便看看</div>
                        <ul class="fa-ul blog-module-ul">
                            <c:forEach var="articleNew" items="${articleListNew}">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="${pageContext.request.contextPath}/article/search/${articleNew.articleId}">${articleNew.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
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
	var editor = new wangEditor('textarea-articleComment');
	
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
<script src="${pageContext.request.contextPath}/js/about.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
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
	// 点击提交评论按钮
	$(".articlecomment-add-button").click(function(){
		var articleId = $("#articleId-input").val();
		var isreply = $("#isreply-input").val();
		var userIdAuthor = $("#userIdAuthor-input").val();
		var userIdReply = $("#userIdReply-input").val();
		var commentPid = $("#commentPid-input").val();
		var commentContent = $("#textarea-articleComment").val();
		var forwardUrl = "${pageContext.request.contextPath}/articlecomment/add";
		var data = {"articleId":articleId,
				"articleCommmentIsreply":isreply,
				"userIdAuthor":userIdAuthor,
				"userIdReply":userIdReply,
				"articleCommentPid":commentPid,
				"articleCommentContent":commentContent};
		$.post(forwardUrl,data,function(){
			window.location.reload();
			return;
		});
	});
	// 点击回复
	$(".reply-a").click(function(){
		$(".articlecomment-add-button").html("回复");
		$("#isreply-input").val(1);
		$("#userIdReply-input").val($(this).parent().siblings("div .info").children(".span-userId").html());
		var commentPid = $(this).parent().siblings("div .info").children(".span-commentPid").html();
		$("#commentPid-input").val(commentPid);
		$("#textarea-articleComment").focus();
	});
	// 点击删除
	$(".a-deletemessage").click(function(){
		var commentId = $(this).parent().siblings("div .info").children(".span-commentId").html();
		var articleId = $("#articleId-input").val();
		var forwardUrl = "${pageContext.request.contextPath}/articlecomment/delete";
		var data = {"articleId":articleId,
				"articleCommentId":commentId};
		$.post(forwardUrl,data,function(){
			window.location.reload();
			return;
		});
	});
	
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