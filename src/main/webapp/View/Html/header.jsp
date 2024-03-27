 <!-- Header -->
    <%@ page  language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <header>
      <!-- Header desktop -->
      <div class="container-menu-desktop">
        <!-- Topbar -->
        <div class="top-bar">
          <div class="content-topbar flex-sb-m h-full container">
            <div class="left-top-bar">

            </div>

            <div class="right-top-bar flex-w h-full">
              
                <c:choose>
                    <c:when test="${sessionScope.customer == null }">
                      <a href="front?controller=register" class="flex-c-m trans-04 p-lr-25">Register</a>
                    </c:when>
                    <c:otherwise>
                      <a href="front?controller=updateCustomer" class="flex-c-m trans-04 p-lr-25"> My Account </a>
                      <a href="front?controller=logout" class="flex-c-m trans-04 p-lr-25"> Logout </a>
                    </c:otherwise>
                </c:choose>

            </div>
          </div>
        </div>

        <div class="wrap-menu-desktop">
          <nav class="limiter-menu-desktop container">
            <!-- Logo desktop -->
            <a href="front?" class="logo">
              <img src="assets/Images/icons/logo.png" alt="IMG-LOGO" />
            </a>

            <!-- Menu desktop -->
            <div class="menu-desktop">
              <ul class="main-menu">
                <li class="${param.active == 'home' ? 'active-menu' : ''}">
                  <a href="front?">Home</a>
                </li>

                <li class="${param.active == 'shop' ? 'active-menu' : ''}">
                  <a href="front?controller=products">Shop</a>
                </li>
                <li class="${param.active == 'blog' ? 'active-menu' : ''}">
                  <a href="front?controller=blog">Blog</a>
                </li>
<%--                <li class="${param.active == 'blog' ? 'active-menu' : ''}">--%>
<%--                  <a href="front?controller=adminLogin">Admin</a>--%>
<%--                </li>--%>

                <li class="${param.active == 'about' ? 'active-menu' : ''}">
                  <a href="front?controller=about">About</a>
                </li>

                <li class="${param.active == 'contact' ? 'active-menu' : ''}">
                  <a href="front?controller=contact">Contact</a>
                </li>

              </ul>
            </div>

            <!-- Icon header -->
            <div class="wrap-icon-header flex-w flex-r-m" 
>
              <div
                class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart cart-count"
                data-notify="0"
              >
                <i class="zmdi zmdi-shopping-cart" ></i>
              </div>
            </div>
          </nav>
        </div>
      </div>

      <!-- Header Mobile -->
      <div class="wrap-header-mobile">
        <!-- Logo moblie -->
        <div class="logo-mobile">
          <a href="front?"
            ><img src="assets/Images/icons/logo.png" alt="IMG-LOGO"
          /></a>
        </div>

          <div class="wrap-icon-header flex-w flex-r-m m-1 mt-2">
              <div
                      class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart cart-count"
                      data-notify="0">
                  <i class="zmdi zmdi-shopping-cart" ></i>
              </div>
          </div>

        <!-- Button show menu -->
        <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
          <span class="hamburger-box">
            <span class="hamburger-inner"></span>
          </span>
        </div>
      </div>

      <!-- Menu Mobile -->
      <div class="menu-mobile">
        <ul class="topbar-mobile">
          <li>
            <div class="left-top-bar">
              Free shipping for standard order over $100
            </div>
          </li>

          <li>
            <div class="right-top-bar flex-w h-full">
              <c:choose>
                    <c:when test="${sessionScope.customer == null }">
                      <a href="front?controller=register" class="flex-c-m trans-04 p-lr-25">Register</a>
                    </c:when>
                    <c:otherwise>
                      <a href="front?controller=updateCustomer" class="flex-c-m trans-04 p-lr-25"> My Account </a>
                    </c:otherwise>
                </c:choose>
          </li>
        </ul>

        <ul class="main-menu-m">
          <li>
            <a href="front?">Home</a>
            <span class="arrow-main-menu-m">
              <i class="fa fa-angle-right" aria-hidden="true"></i>
            </span>
          </li>
          <li>
            <a href="front?controller=products">Shop</a>
          </li>
          <li>
            <a href="front?controller=blog">Blog</a>
          </li>
          <li>
            <a href="front?controller=about">About</a>
          </li>
          <li>
            <a href="front?controller=contact">Contact</a>
          </li>

            <li class="${param.active == 'contact' ? 'active-menu' : ''}">

            </li>
        </ul>
      </div>
        <script src="assets/Scripts/header.js"></script>
    </header>

