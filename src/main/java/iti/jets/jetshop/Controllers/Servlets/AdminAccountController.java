package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class AdminAccountController implements ControllerInt {
    private static AdminAccountController instance;

    private AdminAccountController() {}

    public static AdminAccountController getInstance() {
        if (instance == null) {
            instance = new AdminAccountController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST"))
        {

        }else
        {
            List<CustomerDto> customers = CustomerService.getAllCustomers();
            request.setAttribute("customers",customers);
            resolver.forward(ViewEnum.AdminAccount.getViewPath());
        }
        return resolver;
    }
}