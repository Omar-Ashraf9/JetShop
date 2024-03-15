package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        resolver.forward(ViewEnum.ShoppingCart.getViewPath());

        return resolver;
    }
}
