package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginController implements ControllerInt {
    private static LoginController instance;

    private LoginController() {
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST")) {
            try {
                BufferedReader reader = request.getReader();
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                String jsonString = sb.toString();
                
                boolean loginResult = CustomerService.login(request.getParameter("email"), request.getParameter("password"));
                if (loginResult) {

                } else {
                    resolver.plainText("please enter a correct email and password");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            resolver.forward(ViewEnum.Login.getViewPath());
        }
        return resolver;
    }
}