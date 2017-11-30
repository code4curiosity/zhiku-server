<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="./layout/header.jsp"%>
	</head>
	<body>
	<c:set var="index" scope="session" value="4"/>
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
							<h1>对日培训</h1>
							<h2>对日软件服务外包产业，在工作的过程中，有着其独特的特点，和国内的大多数软件开发的流程上，有很大区别，需要专门的培训</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-explore" class="fh5co-bg-section">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>对日软件的特点</h2>
					<p>对日软件服务外包，顾名思义，就是对日本进行软件接包开发，需要人才具备一定的日语能力才能读懂全日文的设计书，测试书，并且整个开发环境是全日语的，和客户邮件沟通业务也需要能写日语。但是固有计算机专业人才，基本都是英语出身，在日语语言的学习上，也需要投入很大的精力。这就导致了企业在招聘了初期人才后，要投入大量的人力物力来进行培训，大大增加了企业的负担。</p>
				</div>
			</div>
		</div>
		<div class="fh5co-explore">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-pull-1 animate-box">
						<img class="img-responsive" src="${baseurl}/images/work_1.png" alt="work">
					</div>
					<div class="col-md-4 animate-box">
						<div class="mt">
							<div>
								<h4><i class="icon-user"></i>对日软件开发流程</h4>
								<p>严格按照需求分析，基本设计，详细设计，代码开发，单元测试，结合测试，综合测试的国际软件流程进行开发。</p>
							</div>
							<div>
								<h4><i class="icon-video2"></i>日语专项要求</h4>
								<p>对日软件服务外包，顾名思义，就是对日本进行软件接包开发，需要人才具备一定的日语能力才能读懂全日文的设计书，测试书，并且整个开发环境是全日语的，和客户邮件沟通业务也需要能写日语。</p>
							</div>
							<div>
								<h4><i class="icon-shield"></i>培训机构精准对接</h4>
								<p>市场上大量现存的培训机构所培训的人才，也和企业的实际需求相差甚远，而企业想独立组建培训机构，又因行业特征的各种因素，无法快速的组织起相应的市场团队，此模块针对性的向为对日服务外包企业提供人才的培训机构开放，让相关培训机构能够精准的把握对日服务外包企业所需要的真正的人才。</p>
							</div>
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

