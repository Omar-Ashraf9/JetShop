package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.OrderDto;
import iti.jets.jetshop.Services.CustomerService;
import iti.jets.jetshop.Services.OrderService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminLogin implements ControllerInt {
    private static AdminLogin instance;

    private AdminLogin() {}

    public static AdminLogin getInstance() {
        if (instance == null) {
            instance = new AdminLogin();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        if(request.getMethod().equals("POST"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(username.equals("jetshop") && password.equals("reo"))
            {
                ViewResolver resolver = new ViewResolver();
                resolver.redirect(ViewEnum.AdminHome.getViewName());
                return resolver;
            }
            else
            {
                request.setAttribute("error", "Invalid Username or Password");
                ViewResolver resolver = new ViewResolver();
                resolver.forward(ViewEnum.AdminLogin.getViewPath());
                return resolver;
            }
        }
        else
        {
            ViewResolver resolver = new ViewResolver();
            resolver.forward(ViewEnum.AdminLogin.getViewPath());
            return resolver;
        }
    }
}