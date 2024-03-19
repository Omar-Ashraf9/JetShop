package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Services.CartService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddToCart implements ControllerInt {
    private static AddToCart instance;

    private AddToCart() {}
    public static AddToCart getInstance() {
        if (instance == null) {
            instance = new AddToCart();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response)
    {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST")) {
            Integer productId = Integer.parseInt(request.getParameter("productId"));

            HttpSession session = request.getSession(false);
            CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
            if(!ProductService.isQuantityAvailable(productId))
            {
                System.out.println("5elst");
                resolver.plainText("false");
            }else
            {
               if(CartService.addProductToCart(productId,customerDto.getId())) {
                   System.out.println("available");
                   resolver.plainText("true");
               }
               else{
                   System.out.println("msh haykafy");
                   resolver.plainText("false");
               }
            }
        }
        return resolver;
    }
}
