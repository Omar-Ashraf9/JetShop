package iti.jets.jetshop.Controllers;

import iti.jets.jetshop.FrontController.ControllerInt;
import iti.jets.jetshop.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorController implements ControllerInt {
    public ErrorController(){
        System.out.println("error Controller Called");
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();

        resolver.forward("/error.jsp");
        return resolver;
    }
}
