<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="./layout/header.jsp"%>
	</head>
	<body>
	<c:set var="index" scope="session" value="0"/>
	<div class="fh5co-loader"></div>
	
	<div id="page">

	<%@ include file="./layout/nav.jsp"%>
	<header id="fh5co-header" class="fh5co-cover bg-image1" role="banner" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>长春对日服务外包智库<br />公共平台</h1>
							<h2>技术/翻译支持by- <a href="http://www.ccbjb.com.cn/" target="_blank" title="长春必捷必">CCBJB</a></h2>
							<p><a class="btn btn-primary btn-lg btn-learn" href="/zhiku/ebook.tkm">获取课程</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-counter" class="fh5co-counters">
		<div class="container">
			<div class="row">
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="40356" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">学员</span>
				</div>
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="30290" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">课程</span>
				</div>
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="2039" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">讲师</span>
				</div>
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="997585" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">收益</span>
				</div>
			</div>
		</div>
	</div>

	<div id="fh5co-explore" class="fh5co-bg-section">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>行业知识共享</h2>
					<p>收集汇总和汉化专业的行业知识，做出体系化的整理。</p>
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
							<h3>行业案例分析</h3>
							<p>我们将各个行业的专业资料材料总结并进行汉化，通过本公司20余年的行业积累，以及日本各大行业关联论坛收集出各个行业的知识及技术资料</p>
							<ul class="list-nav">
								<li><i class="icon-check2"></i>保险行业</li>
								<li><i class="icon-check2"></i>大型流通行业</li>
								<li><i class="icon-check2"></i>金融行业和公共事业行业</li>
							</ul>
							<p><a class="btn btn-primary btn-lg popup-vimeo btn-video" href="/upload/video/4-6.mp4">获取课程</a></p>
						</div>
					</div>
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
								<h4><i class="icon-user"></i>日本专业技术资源共享</h4>
								<p>权限管理，事务管理，日志管理，排他管理等封装</p>
							</div>
							<div>
								<h4><i class="icon-video2"></i>培训机构精准对接</h4>
								<p>针对性的向对日服务外包企业提供人才的培训机构开放，让相关培训机构能够精准把握对日服务外包企业所需真正的人才</p>
							</div>
							<div>
								<h4><i class="icon-shield"></i>纸质资料电子化</h4>
								<p>纸质资料电子化然后放到“智库”平台中做资源共享。大大节约共享成本。</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="fh5co-project">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>培训讲座</h2>
					<p>针对“行业知识”“日本专业技术资料共享”“培训机构精准对接”以及“纸质资料电子化”开展线下集中培训讲座。</p>
				</div>
			</div>
		</div>
		<div class="container-fluid proj-bottom">
			<div class="row">
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="/zhiku/training.tkm"><img src="${baseurl}/images/project-1.jpg" alt="Web网站开发" class="img-responsive">
						<h3>Web网站开发</h3>
						<span>观看课程</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="/zhiku/training.tkm"><img src="${baseurl}/images/project-2.jpg" alt="对日软件开发流程" class="img-responsive">
						<h3>对日软件开发流程</h3>
						<span>观看课程</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="/zhiku/training.tkm"><img src="${baseurl}/images/project-3.jpg" alt="对日软件测试技法" class="img-responsive">
						<h3>对日软件测试技法</h3>
						<span>观看课程</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="/zhiku/training.tkm"><img src="${baseurl}/images/project-9.jpg" alt="对日软件编码规约" class="img-responsive">
						<h3>对日软件编码规约</h3>
						<span>观看课程</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="/zhiku/training.tkm"><img src="${baseurl}/images/project-5.jpg" alt="VB.NET" class="img-responsive">
						<h3>VB.NET</h3>
						<span>观看课程</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="/zhiku/training.tkm"><img src="${baseurl}/images/project-6.jpg" alt="EXCEL VBA" class="img-responsive">
						<h3>EXCEL VBA</h3>
						<span>观看课程</span>
					</a>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="features">
					<div class="col-md-4 animate-box">
						<h4>最专业的课程</h4>
						<p>20余年委托开发积累的相关技术资料与信息</p>
					</div>
					<div class="col-md-4 animate-box">
						<h4>最专业的讲师</h4>
						<p>从业10余年的对日软件技术经理项目经理</p>
					</div>
					<div class="col-md-4 animate-box">
						<h4>分享的精神</h4>
						<p>将经验分享出来，推动对日软件外包的蓬勃发展</p>
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

