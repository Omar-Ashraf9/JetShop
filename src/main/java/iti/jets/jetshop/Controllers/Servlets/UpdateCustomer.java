package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CartDto;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Services.CartService;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.Optional;

public class UpdateCustomer implements ControllerInt {
    private static UpdateCustomer instance;

    private UpdateCustomer() {
    }

    public static UpdateCustomer getInstance() {
        if (instance == null) {
            instance = new UpdateCustomer();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
            resolver.forward(ViewEnum.Account.getViewPath());
        }
        else{
            CustomerDto oldCustomerDto = (CustomerDto) request.getSession(false).getAttribute("customer");

            CustomerDto customerDto = new CustomerDto(
                    oldCustomerDto.getId(),
                    request.getParameter("name"),
                    oldCustomerDto.getBirthday(),
                    request.getParameter("password"),
                    request.getParameter("job"),
                    oldCustomerDto.getEmail(),
                    new BigDecimal(request.getParameter("creditLimit")),
                    request.getParameter("city"),
                    request.getParameter("country"),
                    request.getParameter("streetName")

            );
            CustomerDto newCustomer =CustomerService.updateCustomerProfile(customerDto).get();

            request.getSession(false).setAttribute("customer",newCustomer);
            resolver.forward(ViewEnum.Home.getViewPath());
        }

        return resolver;
    }
}
