<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Contact</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
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
    <jsp:include page="header.jsp">
      <jsp:param name="active" value="contact" />
    </jsp:include>

    <!-- Cart -->
    <jsp:include page="side-cart.jsp"/>

    <!-- Title page -->
    <section
      class="bg-img1 txt-center p-lr-15 p-tb-92"
      style="background-image: url('assets/Images/bg-01.jpg')"
    >
      <h2 class="ltext-105 cl0 txt-center">Contact</h2>
    </section>

    <!-- Content page -->
    <section class="bg0 p-t-104 p-b-116">
      <div class="container">
        <div class="flex-w flex-tr">
          <div
            class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md"
          >
            <form id="contactForm">
              <h4 class="mtext-105 cl2 txt-center p-b-30">Send Us A Message</h4>
              <div class="bor8 m-b-20 how-pos4-parent">
                  <input
                      class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
                      type="email"
                      id="email"
                      name="email"
                      placeholder="Your Email Address"
                      required
                  />
                  <img
                      class="how-pos4 pointer-none"
                      src="assets/Images/icons/icon-email.png"
                      alt="ICON"
                  />
              </div>

              <div class="bor8 m-b-30">
                  <textarea
                      class="stext-111 cl2 plh3 size-120 p-lr-28 p-tb-25"
                      id="msg"
                      name="msg"
                      placeholder="How Can We Help?"
                      required
                  ></textarea>
    </div>

    <button
        id="submitButton"
        class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer"
        type="submit"
    >
        Submit
    </button>
</form>

          </div>

          <div
            class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md"
          >
            <div class="flex-w w-full p-b-42">
              <span class="fs-18 cl5 txt-center size-211">
                <span class="lnr lnr-map-marker"></span>
              </span>

              <div class="size-212 p-t-2">
                <span class="mtext-110 cl2"> Address </span>

                <p class="stext-115 cl6 size-213 p-t-18">
                Smart Village building B148 - 28 Km by Cairo / Alexandria Desert road- 6 October
                </p>
              </div>
            </div>

            <div class="flex-w w-full p-b-42">
              <span class="fs-18 cl5 txt-center size-211">
                <span class="lnr lnr-phone-handset"></span>
              </span>

              <div class="size-212 p-t-2">
                <span class="mtext-110 cl2"> Lets Talk </span>

                <p class="stext-115 cl1 size-213 p-t-18">+20-2-353-55656</p>
              </div>
            </div>

            <div class="flex-w w-full">
              <span class="fs-18 cl5 txt-center size-211">
                <span class="lnr lnr-envelope"></span>
              </span>

              <div class="size-212 p-t-2">
                <span class="mtext-110 cl2"> Sale Support </span>

                <p class="stext-115 cl1 size-213 p-t-18">itiinfo@iti.gov.eg</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Map -->

    <!-- Footer -->
    <jsp:include page="footer.jsp" />


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
<script src="https://cdn.jsdelivr.net/npm/emailjs-com@2.6.4/dist/email.min.js"></script>

    <script type="text/javascript">
   (function() {
            // https://dashboard.emailjs.com/admin/account
            emailjs.init({
              publicKey: "fVLokjsl-V-BCyU5i",
            });
        })();
       document.getElementById("submitButton").addEventListener("click", function() {
        var email = document.getElementById("email").value;
        var msg = document.getElementById("msg").value;
            console.log("Email sent fully!");

        // Send email using EmailJS
        emailjs.send("template_gpnjabj", "service_qikwrd7", {
            to_email: email,
            message: msg
        }).then(function(response) {
            console.log("Email sent successfully!", response);
            // You can handle success here (e.g., show a success message)
        }, function(error) {
            console.error("Error sending email:", error);
            // You can handle errors here (e.g., show an error message)
        });
    });

    </script>
    <!--===============================================================================================-->
    <script src="assets/Scripts/main.js"></script>

  </body>
</html>
