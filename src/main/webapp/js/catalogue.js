$(function () {
    $(".catalogue-item").click(function () {
        var tipsNo = parseInt($(this).data("no"))
        window.location.href = "/ebook/vbabook.tkm?tipsNo=" + tipsNo
    })
    banBack()
})

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