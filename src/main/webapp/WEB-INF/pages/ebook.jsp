<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="./layout/header.jsp"%>
	</head>
	<body>
	<c:set var="index" scope="session" value="3"/>
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<%@ include file="./layout/nav.jsp"%>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm bg-image2" role="banner" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>电子书</h1>
							<h2>对于软件开发行业，专业知识行业知识，是需要时刻更新，时刻吸取的，纸质文档不能更合理资源共享的问题，复印纸质书成本大，任务量大，而把纸质资料电子化然后放到“智库”平台中做资源共享能够大大的节约被共享企业的成本</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-blog">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#" class="e-img-box"><img class="img-responsive" src="${baseurl}/images/project-4.jpg" alt=""></a>
						<div class="blog-text">
							<h3><a href="/ebook/catalogue.tkm" target="_blank">vba电子书</a></h3>
							<span class="posted_on">2017-05-30 11:22:16</span>
							<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>
							<p>操作excel的编程语言</p>
							<a href="/ebook/catalogue.tkm" target="_blank" class="btn btn-primary">开始阅读</a>
						</div>
					</div>
				</div>
				<c:forEach items="${page.list}" var="it">
					<div class="col-lg-4 col-md-4">
						<div class="fh5co-blog animate-box">
							<a class="e-img-box" href="#"><img class="img-responsive" src="${baseurl}${it.imgPath != null ? it.imgPath: '/images/project-4.jpg'}" alt=""></a>
							<div class="blog-text">
								<h3><a href="/zhiku/info.tkm?categoryId=${it.id}&navIndex=3" target="_blank">${it.categoryLabel}</a></h3>
								<span class="posted_on"><fmt:formatDate value="${it.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
								<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>
								<p>${it.description}</p>
								<a href="/zhiku/info.tkm?categoryId=${it.id}&navIndex=3" target="_blank" class="btn btn-primary">开始阅读</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="pagination">
				<div class="pg-content">
					<span class="pg-item prev <c:if test="${!page.hasPreviousPage}">disabled</c:if>" data-value="${page.pageNum}">上一页</span>
					<c:forEach var="i" begin="1" end="${page.pages}">
						<span class="pg-item pg-no <c:if test="${i==page.pageNum}">active</c:if>" data-value="${i}">${i}</span>
					</c:forEach>
					<span class="pg-item next <c:if test="${!page.hasNextPage}">disabled</c:if>" data-value="${page.pageNum}">下一页</span>
					<span class="pg-total">${page.pageNum} / ${page.pages}</span>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="./layout/footer.jsp"%>
	</div>

	<%@ include file="./layout/footerCommon.jsp"%>
	<script>
        $(function () {
            initPagination("/zhiku/ebook.tkm")
        })
	</script>
	</body>
</html>

