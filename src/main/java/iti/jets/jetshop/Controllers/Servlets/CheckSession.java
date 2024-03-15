package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckSession implements ControllerInt {
    private static CheckSession instance;

    private CheckSession() {
    }

    public static CheckSession getInstance() {
        if (instance == null) {
            instance = new CheckSession();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("ttt");
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
            HttpSession session = request.getSession(false);
            if(session==null){
                resolver.forward(ViewEnum.Login.getViewPath());
            }
            else{
                System.out.println("start with cart");
                resolver.forward(ViewEnum.About.getViewPath());

            }

        }
        return resolver;
    }
}
