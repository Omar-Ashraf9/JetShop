package iti.jets.jetshop.Controllers;

import com.google.gson.Gson;
import iti.jets.jetshop.FrontController.ControllerInt;
import iti.jets.jetshop.FrontController.ViewResolve.ViewResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class WelcomeController implements ControllerInt {
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();

        resolver.forward("/welcome.html");


        return resolver;
    }
}


