package iti.jets.jetshop.Controllers.Enums;

import lombok.Getter;

@Getter
public enum ViewEnum {

    Welcome("Welcome", "/View/JSP/welcome.jsp"),
    Header("Header", "/View/Html/header.jsp"),
    Footer("Footer", "/View/Html/footer.jsp"),
    Blog("Blog", "/View/Html/blog.jsp"),
    BlogDetail("BlogDetail", "/View/Html/blog-detail.html"),
    Error("Error", "/View/Html/error.jsp"),
    Register("Register", "/View/Html/sign-up.jsp"),
    Login("login","/View/Html/login.jsp"),
    Product("Product", "/View/Html/product.jsp"),
    ProductDetail("ProductDetail", "/View/Html/product-detail.jsp"),
    About("About", "/View/Html/about.jsp"),
    Contact("Contact", "/View/Html/contact.jsp"),
    ShoppingCart("Cart", "/View/Html/shoping-cart.jsp"),
    Account("account","/View/Html/account.jsp"),
    AdminHome("admin", "/View/Admin/index.jsp"),
    Home("Home.html", "/View/Html/index.jsp"),
    AdminProduct("adminProduct", "/View/Admin/products.jsp"),
    AdminAddProduct("Admin Add Product", "/View/Admin/add-product.jsp"),
    AdminEditProduct("Admin Edit Product", "/View/Admin/edit-product.jsp"),
    AdminAccount("Admin Account", "/View/Admin/accounts.jsp"),
    AdminViewAccount("Admin View Account", "/View/Admin/account-details.jsp"),
    CheckOutDone("CheckOutDone","/View/Html/checkoutDone.html"),
    AdminLogin("Admin Login", "/View/Admin/login.jsp");



    private final String viewName;
    private final String viewPath;

    ViewEnum(String viewName, String viewPath) {
        this.viewName = viewName;
        this.viewPath = viewPath;
    }
}


