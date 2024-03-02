package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorController implements ControllerInt {
    public ErrorController(){
        System.out.println("error Controller Called");
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();

        resolver.forward("/View/JSP/error.jsp");
        return resolver;
    }
}