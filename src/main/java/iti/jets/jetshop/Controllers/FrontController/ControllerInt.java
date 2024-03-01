package iti.jets.jetshop.Controllers.FrontController;

import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerInt {
    ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response);

}
