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
						<a href="#"><img class="img-responsive" src="${baseurl}/images/project-4.jpg" alt=""></a>
						<div class="blog-text">
							<h3><a href=""#>EXCEL VBA</a></h3>
							<span class="posted_on">11/02</span>
							<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>
							<p>在EXCEL中编程使用的编程语言</p>
							<a href="#" class="btn btn-primary">开始阅读</a>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="./layout/footer.jsp"%>
	</div>

	<%@ include file="./layout/footerCommon.jsp"%>

	</body>
</html>

