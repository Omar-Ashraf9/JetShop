package iti.jets.jetshop.FrontController;

import iti.jets.jetshop.Controllers.ErrorController;
import iti.jets.jetshop.Controllers.SecondController;
import iti.jets.jetshop.Controllers.WelcomeController;

public class ControllerFactory {

    public ControllerFactory() {}

    public ControllerInt getController(final String controllerName) {

        switch (controllerName) {
            case "welcome":
                return new WelcomeController();
            case "second":
                return new SecondController();
//                return new BlogController();
            default:
                return new ErrorController();
        }
    }
}