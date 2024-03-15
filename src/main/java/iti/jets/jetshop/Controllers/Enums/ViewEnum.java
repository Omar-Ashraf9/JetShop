package iti.jets.jetshop.Controllers.Enums;

import lombok.Getter;

@Getter
public enum ViewEnum {

    Welcome("Welcome", "/View/JSP/welcome.jsp"),
    Header("Header", "/View/Html/header.jsp"),
    Footer("Footer", "/View/Html/footer.jsp"),
    Blog("Blog", "/View/Html/blog.jsp"),
    Error("Error", "/View/JSP/error.jsp"),
    Register("Register", "/View/Html/sign-up.html"),
    Login("Login","/View/Html/login.html"),
    Product("Product", "/View/Html/product.jsp"),
    ProductDetail("ProductDetail", "/View/Html/product-detail.jsp"),
    About("About", "/View/Html/about.jsp"),
    Contact("Contact", "/View/Html/contact.jsp"),
    ShoppingCart("Cart", "/View/Html/shoping-cart.jsp"),
    Home("Home.html", "/View/Html/index.jsp");


    private final String viewName;
    private final String viewPath;

    ViewEnum(String viewName, String viewPath) {
        this.viewName = viewName;
        this.viewPath = viewPath;
    }
}


