package iti.jets.jetshop.Controllers.Servlets;
import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

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
        if (request.getMethod().equals("GET")) {
            try {
                // Get the list of products
                List<ProductDto> products = ProductService.getAllProducts();
                request.setAttribute("products", products);
//                request.setAttribute("image","https://i.postimg.cc/TPVBgby6/zz.png");
                // Forward to product.jsp
                resolver.forward(ViewEnum.Product.getViewPath());

            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(500); // to indicate server error
            }
        }
        return resolver;
    }

}
