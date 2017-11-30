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
							<h1>联系我们</h1>
							<h2>长春对日服务外包智库公共平台 by- <a href="http://www.ccbjb.com.cn" target="_blank">CCBJB</a></h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-contact">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-md-push-1 animate-box">
					
					<div class="fh5co-contact-info">
						<h3>联系方式</h3>
						<ul>
							<li class="address">长春市高新区飞跃路5588号 <br />东北亚文化创意科技园K座402</li>
							<li class="phone"><a href="tel://0431-89231206">0431-89231206 (总机) / 0431-89231209 (总机) <br /> 0431-89230156 (人事部)</a></li>
							<li class="email"><a href="mailto:hr@ccbjb.com.cn">合作事宜：manager@ccbjb.com.cn <br /> 人事部：hr@ccbjb.com.cn</a></li>
						</ul>
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

