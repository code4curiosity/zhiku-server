<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="./layout/header.jsp"%>
	</head>
	<body>
	<c:set var="index" scope="session" value="5"/>
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
							<h1>培训讲座</h1>
							<h2>线下培训讲座</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-blog">
		<div class="container">
			<div class="row">
				<c:forEach items="${page.list}" var="it">
					<c:choose>
					<c:when test="${it.sourceType == '1'}">
						<div class="col-lg-4 col-md-4">
							<div class="fh5co-blog animate-box">
								<a href="${baseurl}${it.imgPath}" class="popup-vimeo btn-video e-img-box"><img class="img-responsive" src="${baseurl}/images/project-4.jpg" alt=""></a>
								<div class="blog-text">
									<h3><a href="${baseurl}${it.imgPath}" class="popup-vimeo btn-video" >${it.categoryLabel}</a></h3>
									<span class="posted_on"><fmt:formatDate value="${it.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
									<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>
									<p>${it.description}</p>
									<a href="${baseurl}${it.imgPath}" class="btn btn-primary popup-vimeo btn-video">开始观看</a>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-lg-4 col-md-4">
							<div class="fh5co-blog animate-box">
								<a href="#" class="e-img-box"><img class="img-responsive" src="${baseurl}${it.imgPath != null ? it.imgPath: '/images/project-4.jpg'}" alt=""></a>
								<div class="blog-text">
									<h3><a href="/zhiku/info.tkm?categoryId=${it.id}&navIndex=4" target="_blank">${it.categoryLabel}</a></h3>
									<span class="posted_on"><fmt:formatDate value="${it.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
									<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>
									<p>${it.description}</p>
									<a href="/zhiku/info.tkm?categoryId=${it.id}&navIndex=4" target="_blank" class="btn btn-primary">开始阅读</a>
								</div>
							</div>
						</div>
					</c:otherwise>
					</c:choose>
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
            initPagination("/zhiku/chair.tkm")
        })
	</script>
	</body>
</html>

