package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;

public class productDetailController implements ControllerInt {
    private static productDetailController instance;

    private productDetailController() {}

    public static productDetailController getInstance() {
        if (instance == null) {
            instance = new productDetailController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("GET")) {
            String productId = request.getParameter("productId");
            System.out.println("here inside the product details");
            // Fetch product information using productId
            Optional<ProductDto> product = ProductService.getProductById(productId);
            // Now you have the product object, you can use it as needed
            request.setAttribute("product", product.get());
            resolver.forward(ViewEnum.ProductDetail.getViewPath());
        }
        return resolver;
    }
}
