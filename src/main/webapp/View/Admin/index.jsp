<jsp:useBean id="stats" scope="request" type="java.util.Map"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="iti.jets.jetshop.Models.DTO.OrderDto" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Product Admin - Dashboard HTML Template</title>
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link
            rel="stylesheet"
            href="assets/adminAssets/css/fontawesome.min.css"
    />
    <!-- https://fontawesome.com/ -->
    <link
            rel="stylesheet"
            href="assets/adminAssets/css/bootstrap.min.css"
    />
    <!-- https://getbootstrap.com/ -->
    <link
            rel="stylesheet"
            href="assets/adminAssets/css/templatemo-style.css"
    />
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>

<body id="reportsPage">
<div class="" id="home">
    <jsp:include page="adminHeader.jsp">
        <jsp:param name="active" value="home"/>
    </jsp:include>
    <div class="container">
        <div class="row">
            <div class="col">
                <p class="text-white mt-5 mb-5">Welcome back, <b>Admin</b></p>
            </div>
        </div>
        <!-- row -->
        <div class="row tm-content-row">
            <div class="stats-container" style="display: flex; justify-content: space-between;">
                <div class="stat" style="text-align: center; flex-basis: 30%; color: white;">
                    <h2 id="new-users" style="font-size: 2.5rem; margin-bottom: 0.5rem;">${stats.numOfCustomers}</h2>
                    <p><i class="bi bi-people-fill"></i> New Users</p>
                </div>
                <div class="stat" style="text-align: center; flex-basis: 30%; color: white;">
                    <h2 id="total-orders" style="font-size: 2.5rem; margin-bottom: 0.5rem;">${stats.numOfOrders}</h2>
                    <p><i class="bi bi-cart-fill"></i> Total Orders</p>
                </div>
                <div class="stat" style="text-align: center; flex-basis: 30%; color: white;">
                    <h2 id="available-products" style="font-size: 2.5rem; margin-bottom: 0.5rem;">${stats.numOfProducts}</h2>
                    <p><i class="bi bi-box-seam"></i> Available Products</p>
                </div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col"></div>
            <div class="col-12 tm-block-col">
                <div
                        class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll"
                >
                    <h2 class="tm-block-title">Orders List</h2>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ORDER ID.</th>
                            <th scope="col">Customer Name</th>
                            <th scope="col">Ordered At</th>
                            <th scope="col">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${orders}" varStatus="loop">
                            <tr>
                                <td><b>${order.id}</b></td>
                                <td><b>${order.customer.customerName}</b></td>
                                <td>${order.orderedAt}</td>
                                <td>${order.amount}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="adminFooter.jsp"/>
</div>

<script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="assets/adminAssets/js/moment.min.js"></script>
<!-- https://momentjs.com/ -->
<script src="assets/adminAssets/js/Chart.min.js"></script>
<!-- http://www.chartjs.org/docs/latest/ -->
<script src="assets/adminAssets/js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
<script src="assets/adminAssets/js/tooplate-scripts.js"></script>
<script>
    Chart.defaults.global.defaultFontColor = "white";
    let ctxLine,
        ctxBar,
        ctxPie,
        optionsLine,
        optionsBar,
        optionsPie,
        configLine,
        configBar,
        configPie,
        lineChart;
    barChart, pieChart;
    // DOM is ready
    $(function () {
        drawLineChart(); // Line Chart
        drawBarChart(); // Bar Chart
        drawPieChart(); // Pie Chart

        $(window).resize(function () {
            updateLineChart();
            updateBarChart();
        });
    });
</script>
</body>
</html>
