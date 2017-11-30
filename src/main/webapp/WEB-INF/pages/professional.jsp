<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="./layout/header.jsp"%>
	</head>
	<body>
	<c:set var="index" scope="session" value="2"/>
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
							<h1>专业技术</h1>
							<h2>日本专业的技术资源，系统的引进，资源共享</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-pricing">
		<div class="container">
			<div class="row">
				<div class="pricing">
					<div class="col-md-3 animate-box">
						<div class="price-box">
							<h2 class="pricing-plan">权限管理</h2>
							<ul class="classes">
								<li>功能权限管理技术实现</li>
								<li class="color">角色管理</li>
								<li class="color">用户角色管理</li>
								<li class="color">用户定义权限</li>
								<li>数据级权限管理技术实现</li>
								<li class="color">硬编码</li>
								<li class="color">使用规则引擎</li>
								<li class="color">使用第三方专业软件</li>
							</ul>
							<a href="#" class="btn btn-select-plan btn-sm">开始探索</a>
						</div>
					</div>

					<div class="col-md-3 animate-box">
						<div class="price-box popular">
							<h2 class="pricing-plan pricing-plan-offer">事务管理</h2>
							<ul class="classes">
								<li>事务管理器</li>
								<li>恢复管理器</li>
								<li>锁管理器</li>
								<li>死锁管理器</li>
								<li>缓存管理器</li>
							</ul>
							<a href="#" class="btn btn-select-plan btn-sm">开始探索</a>
						</div>
					</div>

					<div class="col-md-3 animate-box">
						<div class="price-box">
							<h2 class="pricing-plan">日志管理</h2>
							<ul class="classes">
								<li>存储状态管理</li>
								<li>自动备份设置</li>
								<li class="color">启用自动备份</li>
								<li class="color">备份方式</li>
								<li class="color">备份目录</li>
								<li class="color">自动备份时间</li>
								<li>导入备份数据</li>
								<li class="color">记录类型</li>
								<li class="color">“开始时间”和“结束时间”</li>
								<li class="color">备份目录</li>
								<li class="color"> 姓名（或者IP）</li>
								<li>手动删除数据</li>
								<li class="color">删除对象</li>
								<li class="color">记录类型</li>
								<li class="color">结束日期</li>
							</ul>
							<a href="#" class="btn btn-select-plan btn-sm">开始探索</a>
						</div>
					</div>

					<div class="col-md-3 animate-box">
						<div class="price-box popular">
							<h2 class="pricing-plan pricing-plan-offer">排他管理</h2>
							<ul class="classes">
								<li>共享锁</li>
								<li>排他锁</li>
							</ul>
							<a href="#" class="btn btn-select-plan btn-sm">开始探索</a>
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

