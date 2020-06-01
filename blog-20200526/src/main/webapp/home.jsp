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
    <title>斑点博客</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="${pageContext.request.contextPath}/plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${pageContext.request.contextPath}/plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet" />
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
        <!-- canvas -->
        <canvas id="canvas-banner" style="background: #393D49;"></canvas>
        <!--为了及时效果需要立即设置canvas宽高，否则就在home.js中设置-->
        <script type="text/javascript">
            var canvas = document.getElementById('canvas-banner');
            canvas.width = window.document.body.clientWidth - 10;//减去滚动条的宽度
            if (screen.width >= 992) {
                canvas.height = window.innerHeight * 1 / 3;
            } else {
                canvas.height = window.innerHeight * 2 / 7;
            }
        </script>
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">
                        <span style="color: #009688">斑点博客，作者Shr</span>
                        <span style="color: #009688">与未知的相遇，七分欢喜三分孤寂。</span>
                    </div>
                </div>
                <!--左边文章列表-->
                <div class="blog-main-left">
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
                <!--右边小栏目-->
                <div class="blog-main-right">
                    <div class="blogerinfo shadow">
		                <c:if test="${!empty sessionScope.user}">
                        <div class="blogerinfo-figure">
                            <a href="${pageContext.request.contextPath}/user/userinfo/${sessionScope.user.id}">
                            <img src="${sessionScope.user.icon}" alt="${sessionScope.user.nickname}" />
                            </a>
                        </div>
                        <p class="blogerinfo-nickname"><a href="${pageContext.request.contextPath}/user/userinfo/${sessionScope.user.id}">${sessionScope.user.nickname}</a></p>
                        <hr />
                        <div class="blogerinfo-contact">
                            <a target="_blank" title="给我写信"><i class="fa fa-envelope fa-2x"></i>&nbsp;<span style="font-size:large;">${sessionScope.user.email}</span></a>
                        </div>
                        </c:if>
                    </div>
                    <div></div><!--占位-->
                    
                    <div class="blog-module shadow">
                        <div class="blog-module-title">热文排行</div>
                        <ul class="fa-ul blog-module-ul">
                        	<c:forEach var="articleByHot" items="${articleListByHot}">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="${pageContext.request.contextPath}/article/search/${articleByHot.articleId}">${articleByHot.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    
                    <div class="blog-module shadow">
                        <div class="blog-module-title">推荐</div>
                        <ul class="fa-ul blog-module-ul">
                        	<c:forEach var="articleByTop" items="${articleListByTop}">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="${pageContext.request.contextPath}/article/search/${articleByTop.articleId}">${articleByTop.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    
                    <%--
                    <div class="blog-module shadow">
                        <div class="blog-module-title">最近分享</div>
                        <ul class="fa-ul blog-module-ul">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="http://pan.baidu.com/s/1c1BJ6Qc" target="_blank">Canvas</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="http://pan.baidu.com/s/1kVK8UhT" target="_blank">pagesize.js</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="https://pan.baidu.com/s/1mit2aiW" target="_blank">时光轴</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="https://pan.baidu.com/s/1nuAKF81" target="_blank">图片轮播</a></li>
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">一路走来</div>
                        <dl class="footprint">
                            <dt>2017年03月12日</dt>
                            <dd>新增留言回复功能！人人都可参与回复！</dd>
                            <dt>2017年03月10日</dt>
                            <dd>不落阁2.0基本功能完成，正式上线！</dd>
                            <dt>2017年03月09日</dt>
                            <dd>新增文章搜索功能！</dd>
                            <dt>2017年02月25日</dt>
                            <dd>QQ互联接入网站，可QQ登陆发表评论与留言！</dd>
                        </dl>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">后台记录</div>
                        <dl class="footprint">
                            <dt>2017年03月16日</dt>
                            <dd>分页新增页容量控制</dd>
                            <dt>2017年03月12日</dt>
                            <dd>新增管家提醒功能</dd>
                            <dt>2017年03月10日</dt>
                            <dd>新增Win10快捷菜单</dd>
                        </dl>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">友情链接</div>
                        <ul class="blogroll">
                            <li><a target="_blank" href="http://www.layui.com/" title="Layui">Layui</a></li>
                            <li><a target="_blank" href="http://www.pagemark.cn/" title="页签">页签</a></li>
                        </ul>
                    </div>
                     --%>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    
    <%--
    <!--侧边导航-->
    <ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
        <li class="layui-nav-item layui-this">
            <a href="${pageContext.request.contextPath}/main"><i class="fa fa-home fa-fw"></i>&nbsp;首页</a>
        </li>
        <li class="layui-nav-item">
            <a href="article.html">&nbsp;文章专栏</a>
        </li>
        <li class="layui-nav-item">
            <a href="resource.html">&nbsp;资源分享</a>
        </li>
        <li class="layui-nav-item">
            <a href="about.html">&nbsp;问答</a>
        </li>
        <li class="layui-nav-item">
            <a href="about.html">&nbsp;相册</a>
        </li>
        <li class="layui-nav-item">
            <a href="about.html">&nbsp;留言</a>
        </li>
        <li class="layui-nav-item">
            <a href="timeline.html">&nbsp;文章类型</a>
        </li>
        <li class="layui-nav-item">
            <a href="about.html">&nbsp;用户管理</a>
        </li>
        <li class="layui-nav-item">
            <a href="about.html">&nbsp;角色管理</a>
        </li>
        <li class="layui-nav-item">
            <a href="about.html">&nbsp;权限管理</a>
        </li>
    </ul>
    
    <!--分享窗体-->
    <div class="blog-share layui-hide">
        <div class="blog-share-body">
            <div style="width: 200px;height:100%;">
                <div class="bdsharebuttonbox">
                    <a class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                    <a class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                    <a class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                    <a class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
                </div>
            </div>
        </div>
    </div>
    
    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div> --%>
    <!-- layui.js -->
    <script src="${pageContext.request.contextPath}/plug/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${pageContext.request.contextPath}/js/global.js"></script>
    <!-- 本页脚本 -->
    <script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>