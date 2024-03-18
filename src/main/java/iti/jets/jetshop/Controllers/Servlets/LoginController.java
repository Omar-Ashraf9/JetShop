package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Persistence.Entities.Cart;
import iti.jets.jetshop.Services.CartService;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

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

                String email= request.getParameter("email");
                String password= request.getParameter("password");
                LoginDto loginDto= new LoginDto(password,email);
                Optional<CustomerDto> loginResult = CustomerService.login(loginDto);
                if(loginResult.isPresent())
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("customer", loginResult.get());
                    Cart cart = CartService.getCartFromCustomerId(loginResult.get().getId());
                    if(cart==null){
                        CartService.createCart(loginResult.get());
                    }
                    //add cartItems from localStorage
                    resolver.forward(ViewEnum.Home.getViewPath());
                } else {
                    resolver.plainText("please enter a correct email and password");
                }

        }else{
            resolver.forward(ViewEnum.Login.getViewPath());
        }
        return resolver;
    }
}