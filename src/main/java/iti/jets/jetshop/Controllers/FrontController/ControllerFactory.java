package iti.jets.jetshop.Controllers.FrontController;

import iti.jets.jetshop.Controllers.Servlets.*;

public class ControllerFactory {

    private static ControllerFactory instance;

    private ControllerFactory() {}

    public static ControllerFactory getInstance() {
        if (instance == null) {
            instance = new ControllerFactory();
        }
        return instance;
    }

    public ControllerInt getController(final String controllerName) {

        return switch (controllerName) {
            case "blog" -> BlogController.getInstance();
            case "validateEmail"->EmailValidationController.getInstance();
            case "register" -> RegisterController.getInstance();
            case "products" -> ProductsController.getInstance();
            case "login" ->LoginController.getInstance();
            case "productDetail" -> productDetailController.getInstance();
            case "about" -> AboutController.getInstance();
            case "contact" -> ContactController.getInstance();
            case "checkOut" ->CheckOut.getInstance();
            case "cart" -> ShoppingCartController.getInstance();
            case "addToCart" -> AddToCart.getInstance();
            case "admin" -> AdminHome.getInstance();
            case "adminProduct" -> AdminProductController.getInstance();
            case "adminAddProduct" -> AdminAddProductController.getInstance();
            case "updateQuantity" ->UpdateQuantity.getInstance();
            case "updateCustomer" -> UpdateCustomer.getInstance();
            case "adminEditProduct" -> AdminEditProductController.getInstance();
            case "adminAccount" -> AdminAccountController.getInstance();
            case "adminViewAccount" -> AdminViewAccountController.getInstance();
            case "adminLogin" -> AdminLogin.getInstance();
            case "CheckOutDone" -> CheckOutDone.getInstance();
            case "logout" -> LogoutController.getInstance();
            default -> new ErrorController();
        };
    }
}