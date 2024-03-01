package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Thrid implements ControllerInt {
    private static Thrid instance;

    private Thrid() {}

    public static Thrid getInstance() {
        if (instance == null) {
            instance = new Thrid();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        resolver.forward("/View/JSP/thrid.jsp");
        return resolver;
    }
}
