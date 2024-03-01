package iti.jets.jetshop.Controllers.Enums;

import lombok.Getter;

@Getter
public enum ViewEnum {

    Welcome("Welcome", "/View/JSP/welcome.jsp"),
    Error("Error", "/View/JSP/error.jsp");


    private final String viewName;
    private final String viewPath;

    ViewEnum(String viewName, String viewPath) {
        this.viewName = viewName;
        this.viewPath = viewPath;
    }

}


