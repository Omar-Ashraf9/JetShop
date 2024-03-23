<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="iti.jets.jetshop.Models.DTO.CustomerDto" %>
<jsp:useBean id="customers" scope="request" type="java.util.List"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Product Page - Admin HTML Template</title>
  <link
          rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto:400,700"
  />
  <!-- https://fonts.google.com/specimen/Roboto -->
  <link rel="stylesheet" href="assets/adminAssets/css/fontawesome.min.css" />
  <!-- https://fontawesome.com/ -->
  <link rel="stylesheet" href="assets/adminAssets/css/bootstrap.min.css" />
  <!-- https://getbootstrap.com/ -->
  <link rel="stylesheet" href="assets/adminAssets/css/templatemo-style.css">
  <!--
  Product Admin CSS Template
  https://templatemo.com/tm-524-product-admin
  -->

</head>

<body id="reportsPage">

<jsp:include page="adminHeader.jsp">
  <jsp:param name="active" value="accounts" />
</jsp:include>
<div class="container mt-5">
  <div class="row tm-content-row">
    <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
      <div class="tm-bg-primary-dark tm-block tm-block-products">
        <div class="tm-product-table-container">
          <table class="table table-hover tm-table-small tm-product-table">
            <thead>
              <tr>
                <%--                    <th scope="col">&nbsp;</th>--%>
                <th scope="col">Customer ID</th>
                <th scope="col">Customer Name</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}" varStatus="loop">
              <tr data-href = "front?controller=adminViewAccount&id=${customer.id}">
                <td>${customer.id}</td>
                <td>${customer.customerName}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- table container -->
      </div>
    </div>
  </div>
</div>
<jsp:include page="adminFooter.jsp"/>

<!-- load JS -->
<script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="assets/adminAssets/js/bootstrap.min.js"></script>

<script>
  document.addEventListener("DOMContentLoaded", function() {
    var rows = document.querySelectorAll("tr[data-href]");
    rows.forEach(row => {
      row.addEventListener("click", function() {
        window.location.href = this.dataset.href;
      });
    });
  });
</script>



<!-- https://getbootstrap.com/ -->

</body>
</html>