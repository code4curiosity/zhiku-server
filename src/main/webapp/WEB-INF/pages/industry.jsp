<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="./layout/header.jsp"%>
	</head>
	<body>
	<c:set var="index" scope="session" value="1"/>
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
							<h1>行业知识</h1>
							<h2>为了大家更好的吸收日本的行业知识，我们将各个行业的专业资料材料总结并进行汉化。我们通过本集团公司20余年的行业积累，以及日本各大行业关联论坛收集出各个行业的知识及技术等材料，并做体系的整理，主要通过下面几个大行业例如日本的保险行业、大型流通行业、产业行业、金融行业和公共事业等行业进行展开。</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-explore" class="fh5co-bg-section">
		<div class="container">
			<div class="row">
				<c:forEach items="${page.list}" var="it">
					<div class="col-lg-4 col-md-4">
						<div class="fh5co-blog animate-box">
							<a href="#" class="e-img-box"><img class="img-responsive" src="${baseurl}${it.imgPath != null ? it.imgPath: '/images/project-4.jpg'}" alt=""></a>
							<div class="blog-text">
								<h3><a href="/zhiku/info.tkm?categoryId=${it.id}&navIndex=1" target="_blank">${it.categoryLabel}</a></h3>
								<span class="posted_on"><fmt:formatDate value="${it.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
								<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>
								<p>${it.description}</p>
								<a href="/zhiku/info.tkm?categoryId=${it.id}&navIndex=1" target="_blank" class="btn btn-primary">开始阅读</a>
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
            initPagination("/zhiku/industry.tkm")
        })
	</script>
	</body>
</html>

