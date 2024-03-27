<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shoping Cart</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script defer src="assets/Scripts/cartHandler.js"></script>
    <!--===============================================================================================-->
    <link
      rel="icon"
      type="image/png"
      href="assets/Images/favicon.png"
    />
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
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/Styles/util.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="assets/Styles/main.css"
    />
    <!--===============================================================================================-->
  </head>
  <body class="animsition">
    <!-- Header -->
  <jsp:include page="header.jsp"/>
  <br/>
  <br/>
  <br/>

    <!-- Cart -->
    <jsp:include page="side-cart.jsp"/>

    <!-- breadcrumb -->
    <div class="container">
      <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
        <a href="front?" class="stext-109 cl8 hov-cl1 trans-04">
          Home
          <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
        </a>

        <span class="stext-109 cl4"> Shoping Cart </span>
      </div>
    </div>

    <!-- Shoping Cart -->
    <form class="bg0 p-t-75 p-b-85">
      <div class="container">
        <div class="row">
          <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
            <div class="m-l-25 m-r--38 m-lr-0-xl">
              <div class="wrap-table-shopping-cart">
                <table class="table-shopping-cart">
                  <tr class="table_head">
                    <th class="column-1">Product</th>
                    <th class="column-2"></th>
                    <th class="column-3">Price</th>
                    <th class="column-4">Quantity</th>
                    <th class="column-5">Total</th>
                  </tr>
                  <c:forEach var="cartItem" items="${cartItems}">
                  <tr class="table_row">
                    <td class="column-1">
                      <div class="how-itemcart1">
                        <img
                          src="${cartItem.getProduct().productImages[0].getImageUrl()}"
                          alt="IMG"
                        />
                      </div>
                    </td>
                    <td class="column-2">${cartItem.getProduct().getProductName()}</td>
                    <td class="column-3">EGP ${cartItem.getProduct().getProductPrice()}</td>
<%--                    <td class="column-4">--%>
<%--                      <div class="wrap-num-product flex-w m-l-auto m-r-0">--%>
<%--                        <div--%>
<%--                          class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m"--%>
<%--                        >--%>
<%--                          <i class="fs-16 zmdi zmdi-minus"></i>--%>
<%--                        </div>--%>

<%--                        <input--%>
<%--                          class="mtext-104 cl3 txt-center num-product"--%>
<%--                          type="number"--%>
<%--                          name="num-product1"--%>
<%--                          value="1"--%>
<%--                        />--%>

<%--                        <div--%>
<%--                          class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m"--%>
<%--                        >--%>
<%--                          <i class="fs-16 zmdi zmdi-plus"></i>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </td>--%>
                    <%-- <td class="column-5"> ${cartItem.getQuantity()}</td> --%>

                                          <c:choose>
                                            <c:when test="${cartItem.getProduct().getStockQuantity() == 0}">
                                              <td class="column-4"> <div class="error-message">out of stock</div></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class="column-4">
                                                    <div class="dropdown">
                                                        <select id="quantityDropdown" class="quantity-select" onchange="handleQuantityChange(this,${cartItem.getProduct().getId()})">
                                                                <%--                          <option value="${cartItem.getQuantity()}">${cartItem.getQuantity()}</option>--%>
                                                            <c:forEach var="quantity" begin="1" end="${cartItem.getProduct().getStockQuantity()}">
                                                                <option value="${quantity}" ${quantity == cartItem.getQuantity() ? 'selected' : ''}>${quantity}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </td>
                                          </c:otherwise>
                                        </c:choose>

                    <td  class="column-5">EGP ${cartItem.getAmount()}</td>
                  </tr>
                  </c:forEach>

                </table>

              </div>
            </div>
          </div>

          <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
            <div
              class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm"
            >
              <h4 class="mtext-109 cl2 p-b-30">Cart Totals</h4>

              <div class="flex-w flex-t p-t-27 p-b-33">
                <div class="size-208">
                  <span class="mtext-101 cl2"> Total: </span>
                </div>

                <div class="size-209 p-t-1">
                  <span class="mtext-110 cl2"> EGP ${total} </span>
                </div>
              </div>

                <a id="check" class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer" onclick="check_out()" style="color: #ffffff;">Proceed to Checkout</a>
                <label id="checkoutError" class="error-message"></label>
            </div>
          </div>
        </div>
      </div>
    </form>
    <!-- Footer -->
    
    <jsp:include page="footer.jsp" />

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
    <script src="assets/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
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
    <script src="assets/Scripts/shopping-cart.js"></script>
  </body>
</html>
