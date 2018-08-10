$(document).ready(function () {
    var loadmore= $('#load-more');
    console.log("你好");
    var parent =$('#work-grid');
    var text = ' <div class="col-md-4 col-sm-4 col-xs-12 mix branding">\n' +
        '                    <div class="img home-portfolio-image">\n' +
        '                        <img src="assets/images/work/model1.png" alt="Portfolio Item">\n' +
        '                        <div class="overlay-thumb">\n' +
        '                            <a href="javascript:void(0)" class="like-product">\n' +
        '                                <i class="fa fa-heart"></i>\n' +
        '                                <span class="like-product">Liked</span>\n' +
        '                                <span class="output">250</span>\n' +
        '                            </a>\n' +
        '                            <div class="details">\n' +
        '                                <span class="title">紫色</span>\n' +
        '                                <span class="info">忧郁的心情</span>\n' +
        '                            </div>\n' +
        '                            <span class="btnBefore"></span>\n' +
        '                            <span class="btnAfter"></span>\n' +
        '                            <a class="main-portfolio-link" href="getdetail.jsp?imgURL=model1"></a>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                </div>';
    loadmore.click(function () {
        console.log("aaaa1");
        parent.append(text);
    });
});