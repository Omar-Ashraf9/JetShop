package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            resolver.forward(ViewEnum.Product.getViewPath());
        return resolver;
    }
}
