package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
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

            System.out.println(email+"here");

            if(CustomerService.isEmailFound(email))
            {
                Gson gson = new Gson();
                String jsonString = gson.toJson("emailExists: false");
                resolver.plainText(jsonString);
//                resolver.plainText("emailExists: false");
            }else
            {
                Gson gson = new Gson();
                String jsonString = gson.toJson("emailExists: true");
                resolver.plainText(jsonString);
                //resolver.plainText("emailExists: true");
            }

        }
        return resolver;
    }
}
