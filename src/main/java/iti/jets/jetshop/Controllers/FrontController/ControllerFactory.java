package iti.jets.jetshop.Controllers.FrontController;

import iti.jets.jetshop.Controllers.Servlets.ErrorController;
import iti.jets.jetshop.Controllers.Servlets.SecondController;
import iti.jets.jetshop.Controllers.Servlets.Thrid;
import iti.jets.jetshop.Controllers.Servlets.WelcomeController;

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
            case "second" -> SecondController.getInstance();
            case "third" -> Thrid.getInstance();
            default -> new ErrorController();
        };
    }
}