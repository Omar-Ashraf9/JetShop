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
            case "welcome" -> WelcomeController.getInstance();
            case "blog" -> BlogController.getInstance();
            case "third" -> Thrid.getInstance();
            case "validateEmail"->EmailValidationController.getInstance();
            case "register" -> RegisterController.getInstance();
            default -> new ErrorController();
        };
    }
}