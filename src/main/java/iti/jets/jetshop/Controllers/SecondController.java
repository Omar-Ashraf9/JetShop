package iti.jets.jetshop.Controllers;

import iti.jets.jetshop.FrontController.ControllerInt;
import iti.jets.jetshop.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondController implements ControllerInt {
    private static SecondController instance;

    private SecondController() {}

    public static SecondController getInstance() {
        if (instance == null) {
            instance = new SecondController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        resolver.forward("/second.jsp");
        return resolver;
    }
}