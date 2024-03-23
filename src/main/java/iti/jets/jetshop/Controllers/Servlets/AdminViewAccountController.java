package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.DTO.OrderDto;
import iti.jets.jetshop.Services.CustomerService;
import iti.jets.jetshop.Services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class AdminViewAccountController implements ControllerInt {
    private static AdminViewAccountController instance;

    private AdminViewAccountController() {}

    public static AdminViewAccountController getInstance() {
        if (instance == null) {
            instance = new AdminViewAccountController();
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
            String customerId = request.getParameter("id");
            CustomerDto customer = CustomerService.getCustomerById(Integer.parseInt(customerId));
            List<OrderDto> orders = OrderService.getOrdersByCustomerId(Integer.parseInt(customerId));

            request.setAttribute("orders", orders);
            request.setAttribute("customer", customer);

            resolver.forward(ViewEnum.AdminViewAccount.getViewPath());
        }
        return resolver;
    }
}