package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Services.CustomerService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

public class AddProductController implements ControllerInt {
    private static AddProductController instance;

    private AddProductController() {}
    public static AddProductController getInstance() {
        if (instance == null) {
            instance = new AddProductController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response)
    {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST")) {
            String quantity = request.getParameter("quantity");
            String product = request.getParameter("product");

//            if(ProductService.isQuantityAvailable(quantity,product))
//            {
//                resolver.plainText("false");
//            }else
//            {
//                resolver.plainText("true");
//            }
        }
        return resolver;
    }
}
