<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="iti.jets.jetshop.Models.DTO.ProductDto" %>
<jsp:useBean id="product" scope="request" type="iti.jets.jetshop.Models.DTO.ProductDto"/>
<jsp:useBean id="categories" scope="request" type="java.util.List"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Edit Product - Dashboard Admin Template</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="assets/adminAssets/css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <!-- http://api.jqueryui.com/datepicker/ -->
    <link rel="stylesheet" href="assets/adminAssets/css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="assets/adminAssets/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
  </head>

  <body>
  <jsp:include page="adminHeader.jsp">
    <jsp:param name="active" value="editProduct" />
  </jsp:include>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Edit Product</h2>
              </div>
            </div>
            <div class="row tm-edit-product-row">
              <div class="col-xl-6 col-lg-6 col-md-12">
                <form action="front?controller=adminEditProduct&id=${product.id}" method="post" class="tm-edit-product-form">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Product Name
                    </label>
                    <input
                      id="name"
                      name="name"
                      type="text"
                      value="${product.productName}"
                      class="form-control validate"
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="description"
                      >Description</label
                    >
                    <textarea                    
                      class="form-control validate tm-small"
                      rows="5"
                      name="description"
                      required
                    >${product.productDescription}</textarea>
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="category"
                      >Category</label
                    >
                    <select class="custom-select tm-select-accounts" id="category" name="category">
                      <c:forEach var="category" items="${categories}">
                        <c:if test="${category.id == product.category.id}">
                          <option value="${category.id}" selected>${category.categoryName}</option>
                        </c:if>
                        <c:if test="${category.id != product.category.id}">
                          <option value="${category.id}">${category.categoryName}</option>
                        </c:if>
                      </c:forEach>
                    </select>
                  </div>
                  <div class="row">
                      <div class="form-group mb-3 col-xs-12 col-sm-6">
                        <label
                                for="price"
                        >Price
                        </label>
                        <input
                                id="price"
                                name="price"
                                type="number"
                                value="${product.productPrice}"
                                class="form-control validate"
                                min="0"
                                data-large-mode="true"
                        />
                        </div>
                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                          <label
                                  for="stock"
                          >Units In Stock
                          </label>
                          <input
                                  id="stock"
                                  name="stock"
                                  type="number"
                                  value="${product.stockQuantity}"
                                  min="1"
                                  class="form-control validate"
                                  required
                          />
                        </div>
                  </div>
                  
              </div>
              <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                <div class="form-group mb-3">
                  <label for="image1">Image URL 1</label>
                  <input id="image1" name="image1" type="text" class="form-control validate" value="${product.productImages[0].imageUrl}"/>
                </div>
                <div class="form-group mb-3">
                  <label for="image2">Image URL 2</label>
                  <input id="image2" name="image2" type="text" class="form-control validate" value="${product.productImages[1].imageUrl}"/>
                </div>
                <div class="form-group mb-3">
                  <label for="image3">Image URL 3</label>
                  <input id="image3" name="image3" type="text" class="form-control validate" value="${product.productImages[2].imageUrl}" />
                </div>
              </div>
              <div class="col-12">
                <button type="submit" class="btn btn-primary btn-block text-uppercase">Update Now</button>
              </div>
            </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  <jsp:include page="adminFooter.jsp"/>

    <script src="assets/adminAssets/js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->

    <!-- https://jqueryui.com/download/ -->
    <script src="assets/adminAssets/js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
  </body>
</html>
