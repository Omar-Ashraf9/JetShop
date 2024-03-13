package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterController implements ControllerInt {
    private static RegisterController instance;

    private RegisterController() {}

    public static RegisterController getInstance() {
        if (instance == null) {
            instance = new RegisterController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
            resolver.forward(ViewEnum.Register.getViewPath());
        } else
        {
            // handle post request


        }


        return resolver;
    }
}
