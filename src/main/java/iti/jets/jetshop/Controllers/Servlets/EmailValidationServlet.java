package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iti.jets.jetshop.Services.CustomerService;

public class EmailValidationServlet implements ControllerInt {
    private static EmailValidationServlet instance;

    private EmailValidationServlet() {}

    public static EmailValidationServlet getInstance() {
        if (instance == null) {
            instance = new EmailValidationServlet();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            CustomerService.isEmailFound(email);
        } else
        {

        }


        return resolver;
    }
}
