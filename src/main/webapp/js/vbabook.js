function scrollHandler(pos) {
    if(Math.abs(this.y) > 200) {
        $('.js-top').addClass('active');
    }else {
        $('.js-top').removeClass('active');
    }
}
function pad(tipsNo) {
    while(tipsNo.length < 3) {
        tipsNo = '0' + tipsNo;
    }
    return tipsNo;
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
function loadPage(tipsNo, isLeft) {
    // window.location.href = "http://localhost:8080/ebook/vbabook.tkm?tipsNo=" + tipsNo
    var url = "http://localhost:8080/ebook/vbabook.tkm?tipsNo=" + tipsNo
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
function init() {
    // 代码格式
    console.log()
    $('pre code').each(function(i, block) {
        hljs.highlightBlock(block);
    });
    if($(".ql-syntax").length > 0) {
        if($(".ql-syntax").length > 0 && $(".ql-syntax").html()) {
            $(".ql-syntax").each(function () {
                var temp = $(this).html().replace(/#/g, "'");
                $(this).html(temp)
            })
        }
    }

    // tipNo补0
    $(".tips-no .no").text(pad($(".tips-no .no").text()))
    //
    if($(".img-opt").length > 0) {
        $(".img-opt").click(function () {
            $(".filter").fadeToggle()
            $(".bg-image").fadeToggle()
            var src = $(this).attr('src')
            $(".big-image").attr('src', src)
        })
    }
    if($(".bg-image").length > 0) {
        $(".bg-image").click(function() {
            $(".filter").fadeToggle()
            $(".bg-image").fadeToggle()
            $(".big-image").attr('src', '')
        })
    }
    // 代码复制
    var clipboard = new Clipboard('.copycode');
    clipboard.on('success', function(e) {
        layer.msg('复制代码成功！');
        e.clearSelection();
    });
    clipboard.on('error', function(e) {
        layer.msg('复制代码失败！');
    });

    // 滚动到顶部
    $("#scrollUp").click(function (e) {
        $('html,body').stop().animate({scrollTop: '0px'}, 618);
    });

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
        myScroll.on('scroll', scrollHandler)
    }

    $('.js-gotop').on('click', function(event){

        myScroll.scrollTo(0, 0, 400)

        return false;
    });

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
        if(delta < 0) {
            if(Math.abs(delta) > Math.abs(window.innerWidth * 0.15)) {
                var tipsNo = parseInt($(this).data("no")) + 1
                if (tipsNo > 620) {
                    return;
                }
                loadPage(tipsNo, true)
            }
        }else if(delta > 0) {
            if(Math.abs(delta) > Math.abs(window.innerWidth * 0.15)) {
                var tipsNo = parseInt($(this).data("no")) - 1
                if(tipsNo < 0) {
                    return;
                }
                loadPage(tipsNo)
            }
        }

    })
    $(".wrapper").on('touchend', function (e) {

    })
    $(".opts .opt-right").click(function() {
        var tipsNo = parseInt($(this).data("no")) + 1
        if (tipsNo > 620) {
            return;
        }
        loadPage(tipsNo, true)
    })
    $(".opts .opt-left").click(function() {
        var tipsNo = parseInt($(this).data("no")) - 1
        if(tipsNo < 0) {
            return;
        }
        loadPage(tipsNo)
    })
    $(".opts .catalogue").click(function () {
        window.location.href = '/ebook/catalogue.tkm'
    })

    banBack()
}
$(function () {
    init()

})