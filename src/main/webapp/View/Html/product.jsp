<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page   import="iti.jets.jetshop.Persistence.Entities.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <!--===============================================================================================-->
<%--    <link rel="icon" type="image/png" href="assets/images/favicon.png"/>--%>
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/bootstrap/css/bootstrap.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/fonts/iconic/css/material-design-iconic-font.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/fonts/linearicons-v1.0.0/icon-font.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/animate/animate.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/css-hamburgers/hamburgers.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/animsition/css/animsition.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/select2/select2.min.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/daterangepicker/daterangepicker.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/slick/slick.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/MagnificPopup/magnific-popup.css"
    />
    <!--===============================================================================================-->
    <link
            rel="stylesheet"
            type="text/css"
            href="assets/vendor/perfect-scrollbar/perfect-scrollbar.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="assets/Styles/util.css"/>
    <link rel="stylesheet" type="text/css" href="assets/Styles/main.css"/>
    <!--===============================================================================================-->
    <script>
        var imageUrl = "${product.getProductImages().get(0).getImageUrl()}";
        console.log(imageUrl);
    </script>
</head>
<body class="animsition">
<!-- Header -->
<jsp:include page="header.jsp">
    <jsp:param name="active" value="shop"/>
</jsp:include>
<br/>
<br/>
<br/>
<!-- Cart -->
    <jsp:include page="side-cart.jsp"/>

<!-- Product -->

<div class="bg0 m-t-23 p-b-140">
    <div class="container">
        <div class="flex-w flex-sb-m p-b-52">
            <div class="flex-w flex-l-m filter-tope-group m-tb-10">
                <button
                        class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
                        data-filter="*"
                >
                    All Products
                </button>

                <button
                        class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
                        data-filter=".women"
                >
                    Women
                </button>

                <button
                        class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
                        data-filter=".men"
                >
                    Men
                </button>

                <button
                        class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
                        data-filter=".watches"
                >
                    Watches
                </button>
                <button
                        class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
                        data-filter=".shoes"
                >
                    Shoes
                </button>
            </div>

            <div class="flex-w flex-c-m m-tb-10">
                <div
                        class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter"
                >
                    <i
                            class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"
                    ></i>
                    <i
                            class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"
                    ></i>
                    Filter
                </div>

                <div
                        class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search"
                >
                    <i
                            class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"
                    ></i>
                    <i
                            class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"
                    ></i>
                    Search
                </div>
            </div>

            <!-- Search product -->
            <div class="dis-none panel-search w-full p-t-10 p-b-15">
                <div class="bor8 dis-flex p-l-15">
                    <button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
                        <i class="zmdi zmdi-search"></i>
                    </button>

                    <input
                            class="mtext-107 cl2 size-114 plh2 p-r-15"
                            type="text"
                            name="search-product"
                            placeholder="Search"
                    />
                </div>
            </div>

            <!-- Filter -->
            <div class="dis-none panel-filter w-full p-t-10">
                <div
                        class="wrap-filter flex-w bg6 w-full p-lr-40 p-t-27 p-lr-15-sm"
                >
<%--                    <div class="filter-col1 p-r-15 p-b-27">--%>
<%--                        <div class="mtext-102 cl2 p-b-15">Sort By</div>--%>

<%--                        <ul>--%>
<%--                            <li class="p-b-6">--%>
<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Default--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Popularity--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Average rating--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                                <a--%>
<%--                                        href="#"--%>
<%--                                        class="filter-link stext-106 trans-04 filter-link-active"--%>
<%--                                >--%>
<%--                                    Newness--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Price: Low to High--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Price: High to Low--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>

                    <div class="filter-col2 p-r-15 p-b-27 filter-price-group">
                        <div class="mtext-102 cl2 p-b-15">Price</div>

                        <ul>
                            <li class="p-b-6">
                                <button
                                        href="#"
                                        class="filter-link stext-106 trans-04" data-filter ="*">
                                >
                                    All
                                </button>
                            </li>

                            <li class="p-b-6">
                                <button href="#" class="filter-link stext-106 trans-04" data-filter=".price-200-500">
                                    EGP 200.00 - EGP 500.00
                                </button>
                            </li>

                            <li class="p-b-6">
                                <button href="#" class="filter-link stext-106 trans-04" data-filter=".price-500-1000">
                                    EGP 500.00 - EGP 1000.00
                                </button>
                            </li>

                            <li class="p-b-6">
                                <button href="#" class="filter-link stext-106 trans-04" data-filter=".price-1000-1500">
                                    EGP 1000.00 - EGP 1500.00
                                </button>
                            </li>

                            <li class="p-b-6">
                                <button href="#" class="filter-link stext-106 trans-04" data-filter=".price-1500-2000">
                                    EGP 1500.00 - EGP 2000.00
                                </button>
                            </li>

                            <li class="p-b-6">
                                <button href="#" class="filter-link stext-106 trans-04" data-filter=".price-1000-pls">
                                    EGP 2000.00+
                                </button>
                            </li>
                        </ul>
                    </div>

<%--                    <div class="filter-col3 p-r-15 p-b-27">--%>
<%--                        <div class="mtext-102 cl2 p-b-15">Color</div>--%>

<%--                        <ul>--%>
<%--                            <li class="p-b-6">--%>
<%--                    <span class="fs-15 lh-12 m-r-6" style="color: #222">--%>
<%--                      <i class="zmdi zmdi-circle"></i>--%>
<%--                    </span>--%>

<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Black--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                    <span class="fs-15 lh-12 m-r-6" style="color: #4272d7">--%>
<%--                      <i class="zmdi zmdi-circle"></i>--%>
<%--                    </span>--%>

<%--                                <a--%>
<%--                                        href="#"--%>
<%--                                        class="filter-link stext-106 trans-04 filter-link-active"--%>
<%--                                >--%>
<%--                                    Blue--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                    <span class="fs-15 lh-12 m-r-6" style="color: #b3b3b3">--%>
<%--                      <i class="zmdi zmdi-circle"></i>--%>
<%--                    </span>--%>

<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Grey--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                    <span class="fs-15 lh-12 m-r-6" style="color: #00ad5f">--%>
<%--                      <i class="zmdi zmdi-circle"></i>--%>
<%--                    </span>--%>

<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    Green--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                    <span class="fs-15 lh-12 m-r-6" style="color: #fa4251">--%>
<%--                      <i class="zmdi zmdi-circle"></i>--%>
<%--                    </span>--%>

<%--                                <a href="#" class="filter-link stext-106 trans-04"> Red </a>--%>
<%--                            </li>--%>

<%--                            <li class="p-b-6">--%>
<%--                    <span class="fs-15 lh-12 m-r-6" style="color: #aaa">--%>
<%--                      <i class="zmdi zmdi-circle-o"></i>--%>
<%--                    </span>--%>

<%--                                <a href="#" class="filter-link stext-106 trans-04">--%>
<%--                                    White--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>

<%--                    <div class="filter-col4 p-b-27">--%>
<%--                        <div class="mtext-102 cl2 p-b-15">Tags</div>--%>

<%--                        <div class="flex-w p-t-4 m-r--5">--%>
<%--                            <a--%>
<%--                                    href="#"--%>
<%--                                    class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"--%>
<%--                            >--%>
<%--                                Fashion--%>
<%--                            </a>--%>

<%--                            <a--%>
<%--                                    href="#"--%>
<%--                                    class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"--%>
<%--                            >--%>
<%--                                Lifestyle--%>
<%--                            </a>--%>

<%--                            <a--%>
<%--                                    href="#"--%>
<%--                                    class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"--%>
<%--                            >--%>
<%--                                Denim--%>
<%--                            </a>--%>

<%--                            <a--%>
<%--                                    href="#"--%>
<%--                                    class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"--%>
<%--                            >--%>
<%--                                Streetstyle--%>
<%--                            </a>--%>

<%--                            <a--%>
<%--                                    href="#"--%>
<%--                                    class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5"--%>
<%--                            >--%>
<%--                                Crafts--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>

        <div class="row isotope-grid">
            <c:forEach var="product" items="${products}">
                <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item ${product.category.getCategoryName()}
<c:choose>
    <c:when test="${product.productPrice le 200}">
        price-200-500
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${product.productPrice le 500}">
                price-500-1000
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${product.productPrice le 1000}">
                        price-1000-1500
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${product.productPrice le 1500}">
                                price-1500-2000
                            </c:when>
                            <c:otherwise>
                                price-2000-pls
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>
">
                    <!-- Block2 -->
                    <div class="block2">
                        <div class="block2-pic hov-img0">
                            <img src="${product.productImages[0].getImageUrl()}" alt="IMG-PRODUCT">
                            <c:if test="${product.stockQuantity >0}">
                                <a href="front?controller=productDetail&productId=${product.id}"
                                   class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04">
                                    Overview
                                </a>
                            </c:if>
                        </div>
                        <div class="block2-txt flex-w flex-t p-t-14">
                            <div class="block2-txt-child1 flex-col-l ">
                                <a href="product-detail.html" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                        ${product.productName}
                                </a>
                                <span class="stext-105 cl3">
                            EGP ${product.productPrice}
                        </span>
                            </div>

                            <c:if test="${product.stockQuantity == 0}">
                                <label  class="error-message">out of stock</label>
                            </c:if>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>
    </div>
</div>


<!-- Footer -->
<jsp:include page="footer.jsp"/>

<!-- Back to top -->
<div class="btn-back-to-top" id="myBtn">
        <span class="symbol-btn-back-to-top">
        <i class="zmdi zmdi-chevron-up"></i>
        </span>
</div>
<!--===============================================================================================-->
<script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="assets/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="assets/vendor/bootstrap/js/popper.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="assets/vendor/select2/select2.min.js"></script>
<script>
    $(".js-select2").each(function () {
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next(".dropDownSelect2"),
        });
    });
</script>
<!--===============================================================================================-->
<script src="assets/vendor/daterangepicker/moment.min.js"></script>
<script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="assets/vendor/slick/slick.min.js"></script>
<script src="assets/Scripts/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="assets/vendor/parallax100/parallax100.js"></script>
<script>
    $(".parallax100").parallax100();
</script>
<!--===============================================================================================-->
<script src="assets/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<script>
    $(".gallery-lb").each(function () {
        // the containers for all your galleries
        $(this).magnificPopup({
            delegate: "a", // the selector for gallery item
            type: "image",
            gallery: {
                enabled: true,
            },
            mainClass: "mfp-fade",
        });
    });
</script>
<!--===============================================================================================-->
<script src="assets/vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
<script src="assets/vendor/sweetalert/sweetalert.min.js"></script>
<script>
    $(".js-addwish-b2, .js-addwish-detail").on("click", function (e) {
        e.preventDefault();
    });

    $(".js-addwish-b2").each(function () {
        var nameProduct = $(this).parent().parent().find(".js-name-b2").html();
        $(this).on("click", function () {
            swal(nameProduct, "is added to wishlist !", "success");

            $(this).addClass("js-addedwish-b2");
            $(this).off("click");
        });
    });

    $(".js-addwish-detail").each(function () {
        var nameProduct = $(this)
            .parent()
            .parent()
            .parent()
            .find(".js-name-detail")
            .html();

        $(this).on("click", function () {
            swal(nameProduct, "is added to wishlist !", "success");

            $(this).addClass("js-addedwish-detail");
            $(this).off("click");
        });
    });

    /*---------------------------------------------*/

    $(".js-addcart-detail").each(function () {
        var nameProduct = $(this)
            .parent()
            .parent()
            .parent()
            .parent()
            .find(".js-name-detail")
            .html();
        $(this).on("click", function () {
            swal(nameProduct, "is added to cart !", "success");
        });
    });
</script>
<!--===============================================================================================-->
<script src="assets/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $(".js-pscroll").each(function () {
        $(this).css("position", "relative");
        $(this).css("overflow", "hidden");
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on("resize", function () {
            ps.update();
        });
    });
</script>
<!--===============================================================================================-->
<script src="assets/Scripts/main.js"></script>
<script src="assets/Scripts/filter.js"></script>
<script>
    // Function to get a parameter from the URL
    function getURLParameter(name) {
        return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
    }
    // Get the 'category' parameter from the URL
    var category = getURLParameter('category');
    console.log(category)
    // If the 'category' parameter is not null, trigger a click event on the corresponding button
    if (category) {
        document.querySelector('.filter-tope-group button[data-filter=".' + category + '"]').click();
    }
</script>

</body>
</html>