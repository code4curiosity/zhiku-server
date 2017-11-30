<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./layout/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>EBOOK</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>长春对日服务外包智库公共平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="免费的对日服务外包公共学习平台" />
    <meta name="keywords" content="免费, 智库, 长春, 对日外包, 对日服务外包,公共平台, html5, css3, mobile first, responsive, vba ,EXCEL ,EXCEL VBA" />
    <link rel="stylesheet" href="${baseurl}/css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="${baseurl}/css/vbabook.css" type="text/css" media="all">
    <link rel="stylesheet" href="${baseurl}/css/monokai-sublime.css" type="text/css" media="all">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="${baseurl}/css/icomoon.css">
</head>
<body>
    <div class="muses">
        <c:set var="tipsNo" scope="session" value="${result.data.tipsNo}"/>
        <div class="filter"></div>
        <div class="bg-image">
            <img class="big-image" />
        </div>
        <div class="opts">
            <div class="opt opt-right catalogue">
                <i class="icon-home"></i>
            </div>
            <c:if test="${result.data.tipsNo > 1}">
                <div class="opt opt-left operator" data-no="${result.data.tipsNo}">
                    <i class="icon-chevron-left"></i>
                </div>
            </c:if>
            <c:if test="${result.data.tipsNo < 620}">
                <div class="opt opt-right operator" data-no="${result.data.tipsNo}">
                    <i class="icon-chevron-right"></i>
                </div>
            </c:if>
        </div>
        <div class="wrapper" data-no="${tipsNo}">
            <div class="container">
                <div class="title">
                    <div class="tips-no btn">
                        <span>Tips</span>
                        <span class="no">${result.data.tipsNo}</span>
                    </div>
                    <h1 class="text t-h1">${result.data.tipsTitle}</h1>
                </div>
                <div class="func content-background">
                    <c:if test="${result.data.funcTitle !=null && result.data.funcTitle != ''}">
                        <div class="func-title">
                            <div class="btn">
                                <span>功能/命令</span>
                            </div>
                            <h2 class="text t-h2">${result.data.funcTitle}</h2>
                        </div>
                    </c:if>
                    <c:if test="${result.data.funcDesc !=null && result.data.funcDesc != ''}">
                        <div class="content—body">
                                ${result.data.funcDesc}
                        </div>
                    </c:if>
                    <c:if test="${fn:length(result.data.tipsFuncList) gt 0}">
                        <div class="func-order">
                            <c:forEach items="${result.data.tipsFuncList}" var="it">
                                <p class="func-name"><span class="dot"></span>${it.funcName}</p>
                                <pre class="code ql-syntax" spellcheck="false">
                                    <code>${it.funcCode}</code>
                                </pre>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <div class="explain content-background">
                    <div class="explain-title">
                        <div class="btn">
                            <span>详解</span>
                        </div>
                    </div>
                    <div class="content—body">
                        ${result.data.tipsExplain}
                    </div>
                    <c:if test="${result.data.explainTableObj != null && fn:length(result.data.explainTableObj) gt 0}">
                        <c:forEach items="${result.data.explainTableObj}" var="it">
                            <div class="explain-table">
                                <div class="explain-title"><i class="icon-speech-bubble"></i><span>${it.title}</span></div>
                                <table>
                                    <tr>
                                        <c:forEach items="${it.heads}" var="head">
                                            <th>${head}</th>
                                        </c:forEach>
                                    </tr>
                                    <c:forEach items="${it.rows}" var="row">
                                        <tr>
                                            <c:forEach items="${row}" var="column">
                                                <td>${column}</td>
                                            </c:forEach>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
                <c:if test="${result.data.tipsCodeObj != null && result.data.tipsCodeObj != ''}">
                    <div class="code content-background">
                        <div class="code-title">
                            <div class="btn">
                                <span>举个例子</span>
                            </div>
                        </div>
                        <div class="content—body">
                            <pre class="code ql-syntax" spellcheck="false">
                                <code><span class="copycode btn" data-clipboard-action="copy" data-clipboard-target="#foo">点击复制</span>${result.data.tipsCodeObj}</code>
                            </pre>
                        </div>
                    </div>
                </c:if>
                <c:if test="${(result.data.imgBefore != null && result.data.imgBefore != '') || (result.data.imgAfter != null && result.data.imgAfter != '')}">
                    <div class="diagram content-background">
                        <div class="diagram-title">
                            <div class="btn">
                                <span>图解</span>
                            </div>
                        </div>
                        <div class="content—body">
                            <c:if test="${result.data.imgBefore != null && result.data.imgBefore != ''}">
                                <div class="diagram-before">
                                    <div class="title"><h3 class="t-h3">执行前</h3>${result.data.imgBeforeDesc}</div>
                                    <div class="image-wrapper">
                                        <img class="img-opt" src="${baseurl}${result.data.imgBefore}" alt="">
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${result.data.imgAfter != null && result.data.imgAfter != ''}">
                                <div class="diagram-after">
                                    <div class="title"><h3 class="t-h3">执行后</h3>${result.data.imgAfterDesc}</div>
                                    <div class="image-wrapper">
                                        <img class="img-opt" src="${baseurl}${result.data.imgAfter}" alt="">
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:if>
                <c:if test="${result.data.noticeTitle != null && result.data.noticeTitle != ''}">
                    <div class="notice content-background">
                        <div class="notice-title">
                            <div class="notice-text">
                                <h2 class="tips t-h2">小提示</h2>
                                <span class="content">${result.data.noticeTitle}</span>
                            </div>
                        </div>
                        <div class="content—body">
                            <c:if test="${result.data.noticeContent != null && result.data.noticeContent != ''}">
                                <div>
                                        ${result.data.noticeContent}
                                </div>
                            </c:if>
                            <c:if test="${result.data.noticeCodeObj != null && result.data.noticeCodeObj != ''}">
                                <div class="notice-code">
                                    <pre class="code ql-syntax" spellcheck="false">
                                        <code>${result.data.noticeCodeObj}</code>
                                    </pre>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
        </div>
    </div>
</body>
<script src="${baseurl}/js/highlight.pack.js"></script>
<script src="${baseurl}/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="${baseurl}/js/jquery.easing.1.3.js"></script>
<script src="${baseurl}/js/clipboard.min.js"></script>
<script src="${baseurl}/js/layer/layer.js"></script>
<script src="${baseurl}/js/iscroll-probe.js"></script>
<script src="${baseurl}/js/vbabook.js"></script>
<script src="${baseurl}/js/fastclick.js"></script>
<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>
</html>
