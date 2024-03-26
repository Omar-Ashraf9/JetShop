package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.*;

public class ProductsController implements ControllerInt {

    private static ProductsController instance;

    private ProductsController() {
    }

    public static ProductsController getInstance() {
        if (instance == null) {
            instance = new ProductsController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("GET")) {
            try {
                List<ProductDto> products = new ArrayList<>();
                String min = request.getParameter("minPrice");
                String max = request.getParameter("maxPrice");
                if (min != null && max != null) {
                    BigDecimal minPrice = new BigDecimal(min);
                    BigDecimal maxPrice = new BigDecimal(max);
                    products = ProductService.getProductsFilteredWithPrice(minPrice, maxPrice);
                } else {
                    // Get the list of All products
                    products = ProductService.getAllProducts();
                }

                request.setAttribute("products", products);
                resolver.forward(ViewEnum.Product.getViewPath());
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(500); // to indicate server error
            }

        }
        else if (request.getMethod().equals("POST")){
            System.out.println("post method called");
            String category = (String) request.getParameter("category");
            int start = Integer.parseInt( request.getParameter("start"));
            List<ProductDto> products2 = ProductService.getProducts(start, category);
            String anchra = "messi";
            resolver.plainText(anchra);
        }
        System.out.println("fsdnjkxcvjkszdvsznf");
        return resolver;
    }

}
