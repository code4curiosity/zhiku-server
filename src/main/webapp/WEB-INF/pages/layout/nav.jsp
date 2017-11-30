<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="fh5co-nav" role="navigation">
    <div class="top">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 text-right">
                    <p class="num">联系电话: 0431-8923 1206</p>
                    <ul class="fh5co-social">
                        <li><a href="#"><i class="icon-sina-weibo"></i></a></li>
                        <li><a href="#"><i class="icon-qq"></i></a></li>
                        <li><a href="#"><i class="icon-github"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="top-menu">
        <div class="container">
            <div class="row">
                <div class="col-xs-1">
                    <div id="fh5co-logo"><a href="/zhiku/first.tkm">智库<span>.</span></a></div>
                </div>
                <div class="col-xs-11 text-right menu-1">
                    <ul>
                        <li class="<c:if test="${index==0}">active</c:if>"><a href="/zhiku/first.tkm">首页</a></li>
                        <shiro:hasPermission name="zhiku:industry">
                        <li class="<c:if test="${index==1}">active</c:if>"><a href="/zhiku/industry.tkm">行业知识</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="zhiku:professional">
                        <li class="<c:if test="${index==2}">active</c:if>"><a href="/zhiku/professional.tkm">专业技术</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="zhiku:ebook">
                        <li class="has-dropdown <c:if test="${index==3}">active</c:if>">
                            <a href="/zhiku/ebook.tkm">电子书</a>
                            <ul class="dropdown">
                                <li><a href="#">EXCEL VBA</a></li>
                            </ul>
                        </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="zhiku:training">
                        <li class="<c:if test="${index==4}">active</c:if>"><a href="/zhiku/training.tkm">对日培训</a></li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="zhiku:contact">
                        <li class="<c:if test="${index==5}">active</c:if>"><a href="/zhiku/contact.tkm">联系我们</a></li>
                        </shiro:hasPermission>
                        <shiro:guest>
                            <li class="btn-cta"><a href="/zhiku/login.tkm"><span>登录/注册</span></a></li>
                        </shiro:guest>
                        <shiro:user>
                            <li class="btn-cta"><a href="#"><span>欢迎[<shiro:principal property="nickname"/>]</span></a></li>
                            <li class="btn-cta"><a href="/user/logout.tkm"><span>退出</span></a></li>
                        </shiro:user>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</nav>