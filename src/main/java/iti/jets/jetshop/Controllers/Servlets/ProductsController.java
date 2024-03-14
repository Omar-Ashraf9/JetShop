package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Services.CustomerService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductsController implements ControllerInt {

    private static ProductsController instance;

    private ProductsController() {}

    public static ProductsController getInstance() {
        if (instance == null) {
            instance = new ProductsController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println("iam iside product controller get");
            Gson gson = new Gson();
//

            List<Product> productList = ProductService.getAllProducts().orElse(Collections.emptyList());
            String jsonProducts = gson.toJson(productList);

            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.print(jsonProducts);
            response.setStatus(201);
            resolver.forward(ViewEnum.Product.getViewPath());
        }
        return resolver;
    }
}
