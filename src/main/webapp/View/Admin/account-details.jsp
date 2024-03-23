<jsp:useBean id="customer" scope="request" type="iti.jets.jetshop.Models.DTO.CustomerDto"/>
<jsp:useBean id="orders" scope="request" type="java.util.List"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Accounts - Product Admin Template</title>
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
<div class="" id="home">
    <jsp:include page="adminHeader.jsp">
        <jsp:param name="active" value="accounts" />
    </jsp:include>
    <div class="container mt-5">
        <!-- row -->
        <div class="row tm-content-row">
            <div class="tm-block-col tm-col-account-settings">
                <div class="tm-bg-primary-dark tm-block tm-block-settings">
                    <h2 class="tm-block-title">Account Details</h2>
                    <form action="" class="tm-signup-form row">
                        <div class="form-group col-lg-6">
                            <label for="name">Customer Name</label>
                            <input
                                    id="name"
                                    name="name"
                                    value="${customer.customerName}"
                                    type="text"
                                    class="form-control validate"
                                    readonly
                            />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="email">Customer Email</label>
                            <input
                                    id="email"
                                    name="email"
                                    type="email"
                                    value="${customer.email}"
                                    class="form-control validate"
                                    readonly
                            />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="birthdate">Birthdate</label>
                            <input id="birthdate" name="birthdate" type="text" value="<fmt:formatDate value='${customer.birthday}' pattern='yyyy-MM-dd' />" readonly class="form-control validate" />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="job">Job</label>
                            <input id="job" name="job" type="text" value="${customer.job}" readonly class="form-control validate" />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="creditLimit">Credit Limit</label>
                            <input id="creditLimit" name="creditLimit" type="number" value="${customer.creditLimit}" readonly class="form-control validate" />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="city">City</label>
                            <input id="city" name="city" type="text" value="${customer.city}" readonly class="form-control validate" />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="country">Country</label>
                            <input id="country" name="country" type="text" value="${customer.country}" readonly class="form-control validate" />
                        </div>
                        <div class="form-group col-lg-6">
                            <label for="streetName">Street Name</label>
                            <input id="streetName" name="streetName" type="text" value="${customer.streetName}" readonly class="form-control validate" />
                        </div>
<%--                        <div class="col-12">--%>
<%--                            <button--%>
<%--                                    type="submit"--%>
<%--                                    class="btn btn-primary btn-block text-uppercase"--%>
<%--                            >--%>
<%--                                Delete This Account--%>
<%--                            </button>--%>
<%--                        </div>--%>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-12 tm-block-col">
        <div
                class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll"
        >
            <h2 class="tm-block-title">Orders List</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ORDER ID.</th>
                    <th scope="col">Ordered At</th>
                    <th scope="col">Total</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="order" items="${orders}" varStatus="loop">
                    <tr>
                        <td><b>${order.id}</b></td>
                        <td>${order.orderedAt}</td>
                        <td>${order.amount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="adminFooter.jsp"/>
</div>

<script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="assets/adminAssets/js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
</body>
</html>
