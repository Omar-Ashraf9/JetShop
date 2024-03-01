package iti.jets.jetshop.FrontController;

import iti.jets.jetshop.Controllers.ErrorController;
import iti.jets.jetshop.Controllers.SecondController;
import iti.jets.jetshop.Controllers.WelcomeController;

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

        switch (controllerName) {
            case "welcome":
                return WelcomeController.getInstance();
            case "second":
                return SecondController.getInstance();
            default:
                return new ErrorController();
        }
    }
}