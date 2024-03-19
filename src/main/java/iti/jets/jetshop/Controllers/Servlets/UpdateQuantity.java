package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CartDto;
import iti.jets.jetshop.Models.DTO.CartItemDto;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.Mappers.CartItemMapper;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Services.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuantity implements ControllerInt {
    private static UpdateQuantity instance;

    private UpdateQuantity() {}

    public static UpdateQuantity getInstance() {
        if (instance == null) {
            instance = new UpdateQuantity();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        CartService cartService = new CartService();

        HttpSession session = request.getSession(false);
        if(session!=null){
            CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
            Integer quantity= Integer.parseInt(request.getParameter("quantity"));
            Integer productId= Integer.parseInt(request.getParameter("productId"));

            for(CartItemDto cartItemdto: CartService.getCartFromCustomerId(customerDto.getId()).getCartItems()){
                if(cartItemdto.getProduct().getId()==productId){
                    CartService.updateCartItemQuantity(cartItemdto,quantity );
                }
            }

        }

        resolver.forward(ViewEnum.ShoppingCart.getViewPath());

        return resolver;
    }
}
