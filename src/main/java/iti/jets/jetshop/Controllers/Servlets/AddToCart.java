package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Persistence.Repository.CartItemRepo;
import iti.jets.jetshop.Services.CartService;
import iti.jets.jetshop.Services.CustomerService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class AddToCart implements ControllerInt {
    private static AddToCart instance;

    private AddToCart() {
    }

    public static AddToCart getInstance() {
        if (instance == null) {
            instance = new AddToCart();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("POST")) {
            Integer productId = Integer.parseInt(request.getParameter("productId"));
            HttpSession session = request.getSession(false);
            CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
            if (!ProductService.isQuantityAvailable(productId)) {
                resolver.plainText("false");
            } else {
                if (CartService.addProductToCart(productId, customerDto.getId())) {
                    System.out.println("available");
                    resolver.plainText("true");
                } else {
                    resolver.plainText("false");
                }
            }
        }else if(request.getMethod().equals("GET")){
            HttpSession session = request.getSession(false);
            CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
            System.out.println("customerDto");
            System.out.println(customerDto);
            if(customerDto != null){
                Optional<Integer> cartId = CustomerService.getCartIdByCustomerId(customerDto.getId());
                System.out.println("cartId" + cartId);
                Integer productId = Integer.parseInt(request.getParameter("productId"));
                System.out.println("productId" + productId);
                Integer cartID = cartId.get();
                CartService.removeCartItemFromCart(cartID,productId);
                System.out.println("cartitem deleted from db");
                resolver.plainText("Deleted from db");
            }else{
                resolver.plainText("Deleted from localStorage");
            }
        }
        return resolver;
    }
}
