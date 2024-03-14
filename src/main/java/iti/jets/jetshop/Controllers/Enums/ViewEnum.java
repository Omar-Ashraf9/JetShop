package iti.jets.jetshop.Controllers.Enums;

import lombok.Getter;

@Getter
public enum ViewEnum {

    Welcome("Welcome", "/View/JSP/welcome.jsp"),
    Header("Header", "/View/Html/header.jsp"),
    Footer("Footer", "/View/Html/footer.jsp"),
    Blog("Blog", "/View/Html/blog.jsp"),
    Error("Error", "/View/JSP/error.jsp"),
    Register("Register", "/WEB-INF/View/Html/sign-up.html"),
    Product("Register", "/View/Html/product.html"),
    Home("Home.html", "/View/Html/about.html");


    private final String viewName;
    private final String viewPath;

    ViewEnum(String viewName, String viewPath) {
        this.viewName = viewName;
        this.viewPath = viewPath;
    }
}


