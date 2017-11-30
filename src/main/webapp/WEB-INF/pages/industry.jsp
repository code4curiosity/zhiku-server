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
							<h2>为了大家更好的吸收日本的行业知识，我们将各个行业的专业资料材料总结并进行汉化。我们通过本集团公司20余年的行业积累，以及日本各大行业关联论坛收集出各个行业的知识及技术等材料，并做体系的整理，主要通过下面几个大行业展开。</h2>
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
					<h2>获取对日软件行业知识</h2>
					<p>主要通过下面几个大行业例如日本的保险行业、大型流通行业、产业行业、金融行业和公共事业等行业进行展开</p>
				</div>
			</div>
		</div>		
		<div class="fh5co-explore fh5co-explore1">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-push-5 animate-box">
						<img class="img-responsive" src="${baseurl}/images/work_1.png" alt="work">
					</div>
					<div class="col-md-4 col-md-pull-8 animate-box">
						<div class="mt">
							<h3>保险行业</h3>
							<p>日本保险业的发展和日本经济的发展密不可分，在日本经济发展的每个阶段，保险业的发展也呈现出不同的特点。进入21世纪，保险被写入日本中小学教科书，大家对保险的理解和认识也相对来说会比较全面而且更加客观的认识。</p>
							<ul class="list-nav">
								<li><i class="icon-check2"></i>日本寿险现状：长期寿险、医疗险，还有一些短期险。</li>
								<li><i class="icon-check2"></i>日本财产险销售主要有三种，即财产保险代理店、保险公司直营渠道、保险经纪公司。</li>
								<li><i class="icon-check2"></i>以日本生命保险公司、日本财产保险公司、日本明治安田生命保险公司为例，对于保险方面的知识学习和掌握。</li>
								<li><i class="icon-check2"></i>根据所了解到的保险业务、服务及相关经营理念收集相关保险行业知识资料。例如日语的关于保险知识的书我们从中进行摘取。</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-push-5 animate-box">
						<img class="img-responsive" src="${baseurl}/images/work_1.png" alt="work">
					</div>
					<div class="col-md-4 col-md-pull-8 animate-box">
						<div class="mt">
							<h3>流通行业</h3>
							<p>流通是指围绕着人与社会的各种产品的社会的、实物的流通，包括有正面和负面经济价值的各种产品。流通是连接生产和消费的活动，是社会再生产的重要环节。</p>
							<ul class="list-nav">
								<li><i class="icon-check2"></i>比如在日本遍地可见的便利店如“7-11”，LAWSON。</li>
								<li><i class="icon-check2"></i>以及日本的产业行业、金融行业、公共事业行业等相关的知识收集并资源共享。</li>
							</ul>
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

