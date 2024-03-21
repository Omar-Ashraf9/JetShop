<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://unpkg.com/scrollreveal"></script>
    <script defer src="assets/Scripts/validateRegistration.js"></script>
    <!-- Link Swiper's CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"
    />
    <link rel="stylesheet" href="assets/Styles/styles.css" />
    <title>Home - Exclusive E-Commerce Website</title>
    <link
      rel="icon"
      type="image/png"
      href="assets/Images/favicon.png"
    />
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
  </head>
  <body class="animsition">
  <jsp:include page="header.jsp">
      <jsp:param name="active" value="" />
  </jsp:include>
    <section class="section">
      <div class="auth_container">
        <div class="auth_content">
          <form action="front?controller=updateCustomer" method="post" class="auth_form">
            <h2 class="form_title">Update your account</h2>
            <p class="auth_p">Enter your new details below</p>
            <div class="container-inputs">
              <div class="fields-group">
                <div class="form-field">
                  <input name ="name" type="text" id="name" placeholder="Name" class="form_input" value="${sessionScope.customer.customerName}"/>
                  <label id="nameError" class="error-message"></label>
                </div>
<%--                <div class="form-field">--%>
<%--                  <input type="email" id="email" placeholder="Email" class="form_input" />--%>
<%--                  <label id="emailError" class="error-message"></label>--%>
<%--                </div>--%>
              </div>

<%--              <div class="fields-group">--%>
<%--                <div class="form-field">--%>
<%--                  <input--%>
<%--                    type="date"--%>
<%--                    placeholder="Date of birth"--%>
<%--                    id="birthdate"--%>
<%--                    class="form_input"--%>
<%--                    value="${sessionScope.customer.birthday}"--%>
<%--                  />--%>
<%--                  <label id="birthdateError" class="error-message"></label>--%>
<%--                </div>--%>
                <div class="form-field">
                  <input name="job"  type="text" id="job" placeholder="Job" class="form_input"  value="${sessionScope.customer.job}"/>
                  <label id="jobError" class="error-message"></label>
                </div>
              </div>

              <div class="fields-group">
                <div class="form-field">
                  <input
                    type="number"
                    placeholder="Credit Limit"
                    id="creditLimit"
                    class="form_input"
                    min="0"
                    value="${sessionScope.customer.creditLimit}"
                    name="creditLimit"
                  />
                  <label id="creditLimitError" class="error-message"></label>
                </div>
                <div class="form-field">
                  <input
                    type="text"
                    placeholder="City"
                    id="city"
                    name="city"
                    class="form_input"
                    value="${sessionScope.customer.city}"
                  />
                  <label id="cityError" class="error-message"></label>
                </div>
              </div>
              <div class="fields-group">
                <div class="form-field">
                  <input
                    type="text"
                    placeholder="Country"
                    id="country"
                    name="country"
                    class="form_input"
                    value="${sessionScope.customer.country}"
                  />
                  <label id="countryError" class="error-message"></label>
                </div>
                <div class="form-field">
                  <input
                    type="text"
                    placeholder="Street Name"
                    id="streetName"
                    name="streetName"
                    class="form_input"
                    value="${sessionScope.customer.streetName}"
                  />
                  <label id="streetNameError" class="error-message"></label>
                </div>
              </div>
              <div class="fields-group">
                <div class="form-field">
                  <input
                    type="password"
                    placeholder="Password"
                    id="password"
                    name="password"
                    class="form_input"
                    value="${sessionScope.customer.password}"
                  />
                  <label id="passwordError" class="error-message"></label>
                </div>
                <div class="form-field">
                  <input
                    type="password"
                    placeholder="Confirm Password"
                    id="confirm_password"
                    name="confirm_password"
                    class="form_input"
                    value="${sessionScope.customer.password}"
                  />
                  <label
                    id="confirm_passwordError"
                    class="error-message"
                  ></label>
                </div>
              </div>
<%--            </div>--%>

            <div class="form-field">
              <button class="form_btn" type="submit">
                Update Account
              </button>
            </div>
<%--            <div class="form-field">--%>
<%--              <span--%>
<%--                >Already have an account?--%>

<%--                <a href="front?controller=login" class="form_auth_link">Login</a></span--%>
<%--              >--%>
<%--            </div>--%>
          </form>
        </div>
      </div>
    </section>
    <!-- Cart -->
    <jsp:include page="side-cart.jsp"/>
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
  </body>
</html>
