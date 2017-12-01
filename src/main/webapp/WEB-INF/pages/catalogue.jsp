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
    <link rel="stylesheet" href="${baseurl}/css/vbabook.css" type="text/css" media="all">
    <link rel="stylesheet" href="${baseurl}/css/reset.css" type="text/css" media="all">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="${baseurl}/css/icomoon.css">
</head>
<body>
    <div class="opts">
        <c:if test="${result.data.pageNum > 1}">
            <div class="opt opt-left operator" data-no="${result.data.pageNum}">
                <i class="icon-chevron-left"></i>
            </div>
        </c:if>
        <c:if test="${result.data.pageNum < result.data.pages}">
            <div class="opt opt-right operator" data-no="${result.data.pageNum}" data-size="${result.data.pages}">
                <i class="icon-chevron-right"></i>
            </div>
        </c:if>
    </div>
    <div class="wrapper"  data-no="${result.data.pageNum}" data-size="${result.data.pages}" >
        <div class="container">
            <div class="catalogue">
                <h1 class="text t-h1">目录</h1>
                <c:forEach items="${result.data.list}" var="it">
                    <div><p class="catalogue-item" data-no="${it.tipsNo}">${it.tipsNo}--${it.tipsTitle}</p></div>
                </c:forEach>
            </div>
            <div class="pagination">--第${result.data.pageNum}页--</div>
        </div>
    </div>
    <div class="gototop js-top">
        <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
    </div>
</body>
<script src="${baseurl}/js/jquery.min.js"></script>
<script src="${baseurl}/js/iscroll-probe.js"></script>
<script src="${baseurl}/js/layer/layer.js"></script>
<script src="${baseurl}/js/catalogue.js"></script>
<script src="${baseurl}/js/fastclick.js"></script>
<script>
    $(function() {
        FastClick.attach(document.body);
    });
</script>
</html>
