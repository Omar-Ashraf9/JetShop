package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static iti.jets.jetshop.Services.CartService.checkout;

public class CheckOutDone implements ControllerInt {
    private static CheckOutDone instance;

    private CheckOutDone() {
    }

    public static CheckOutDone getInstance() {
        if (instance == null) {
            instance = new CheckOutDone();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
           resolver.forward(ViewEnum.CheckOutDone.getViewPath());

        }
        return resolver;
    }
}
