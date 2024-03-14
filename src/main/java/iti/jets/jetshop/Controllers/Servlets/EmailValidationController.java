package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EmailValidationController implements ControllerInt {
    private static EmailValidationController instance;

    private EmailValidationController() {}
    public static EmailValidationController getInstance() {
        if (instance == null) {
            instance = new EmailValidationController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response)
    {
        ViewResolver resolver = new ViewResolver();

        if(request.getMethod().equals("POST")) {
            String email = request.getParameter("email");

            if(CustomerService.isEmailFound(email))
            {
                resolver.plainText("Email is already used");
            }else
            {
                resolver.plainText("Email is good");
            }

        }
        return resolver;
    }
}
