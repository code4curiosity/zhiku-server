$(function () {
    init()
})
function loadPage(pageNo, isLeft) {
    var url = "/catalogue/" + pageNo + '.html'
    $.ajax({
        url : url,
        type : "GET",
        dataType:"html",
        success : function(result) {
            var reg = /<body>([\s\S]*)<\/body>/
            var matches = result.match(reg)
            if(matches) {
                var newBody = $(matches[1])
                if(isLeft) {
                    newBody.find(".wrapper").css("transform", "translate3d(100%, 0, 0)")
                } else {
                    newBody.find(".wrapper").css("transform", "translate3d(-100%, 0, 0)")
                }

                $("body").html(newBody)
                setTimeout(function () {
                    init()
                }.apply(this), 20)
            }

        }
    })
}
function initScroll() {
    // 外层动画
    if(myScroll) {
        setTimeout(function () {
            myScroll.refresh()
        }, 20)
    }else {
        var myScroll = new IScroll('.wrapper', {
            mouseWheel: true,
            probeType: 3
        });
        setTimeout(function () {
            myScroll.refresh()
        }, 20)
    }
}
function initWrapper() {
    $(".wrapper")[0].style.transform = 'translate3d(0, 0, 0)'
    $(".wrapper")[0].style.transitionDuration = '0.4s'
    var touch = {}
    $(".wrapper").on('touchstart', function (e) {
        var _touch = e.originalEvent.targetTouches[0];
        touch.startX = _touch.pageX
    })
    $(".wrapper").on('touchmove', function (e) {
        var _touch = e.originalEvent.targetTouches[0];
        var delta = _touch.pageX - touch.startX
        touch.delta = delta
    })
    $(".wrapper").on('touchend', function (e) {

        if(touch.delta < 0) {
            if(Math.abs(touch.delta) > Math.abs(window.innerWidth * 0.15)) {
                var pageNo = parseInt($(this).data("no")) + 1
                var size = parseInt($(this).data("size"))
                if (pageNo > size) {
                    layer.msg('已经是最后一页啦！');
                    return;
                }
                loadPage(pageNo, true)
            }
        }else if(touch.delta > 0) {
            if(Math.abs(touch.delta) > Math.abs(window.innerWidth * 0.15)) {
                var pageNo = parseInt($(this).data("no")) - 1
                if(pageNo < 1) {
                    layer.msg('没有前一页啦！');
                    return;
                }
                loadPage(pageNo)
            }
        }
    })
}
function initOpts() {
    $(".opts .opt-right").click(function() {
        var pageNo = parseInt($(this).data("no")) + 1
        var size = parseInt($(this).data("size"))
        if (pageNo > size) {
            layer.msg('已经是最后一页啦！');
            return;
        }
        loadPage(pageNo, true)
    })
    $(".opts .opt-left").click(function() {
        var pageNo = parseInt($(this).data("no")) - 1
        if(pageNo < 1) {
            layer.msg('没有前一页啦！');
            return;
        }
        loadPage(pageNo)
    })
}
function init() {
    $(".catalogue-item").click(function () {
        var tipsNo = parseInt($(this).data("no"))
        window.location.href = "/vbabook/" + tipsNo + '.html'
    })
    initScroll()
    initWrapper()
    initOpts()
    banBack()
}
function banBack() {
    if (window.history && window.history.pushState) {
        $(window).on('popstate', function () {
            window.history.pushState('forward', null, '#');
            window.history.forward(1);
        });
    }
    window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
    window.history.forward(1);
}