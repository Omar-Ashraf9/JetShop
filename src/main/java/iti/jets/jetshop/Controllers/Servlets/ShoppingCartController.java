package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CartItemDto;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Services.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartController implements ControllerInt {
    private static ShoppingCartController instance;

    private ShoppingCartController() {}

    public static ShoppingCartController getInstance() {
        if (instance == null) {
            instance = new ShoppingCartController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        CartService cartService = new CartService();
        HttpSession session = request.getSession(false);
        if(session.getAttribute("customer")!=null){
            CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
            BigDecimal total =cartService.getTotalAmount(customerDto);
            System.out.println("inside shopping cart controller");
            List<CartItemDto> cartItemList = new ArrayList<>( CartService.getCartFromCustomerId(customerDto.getId()).getCartItems());
            request.setAttribute("total",total);
            request.setAttribute("cartItems",cartItemList);
            resolver.forward(ViewEnum.ShoppingCart.getViewPath());
        }
        else{
            resolver.forward(ViewEnum.Login.getViewPath());
        }



        return resolver;
    }
}
