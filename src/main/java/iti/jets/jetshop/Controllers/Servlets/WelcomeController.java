package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class WelcomeController implements ControllerInt {
    private static WelcomeController instance;

    private WelcomeController() {}

    public static WelcomeController getInstance() {
        if (instance == null) {
            instance = new WelcomeController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getSession(false)!=null)
            System.out.println("session welcome "+request.getSession(false).getId());
        resolver.forward(ViewEnum.Welcome.getViewPath());

        return resolver;
    }
}


