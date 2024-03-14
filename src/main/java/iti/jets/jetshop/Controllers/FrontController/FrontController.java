package iti.jets.jetshop.Controllers.FrontController;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FrontController extends HttpServlet {
    private static final String CONTROLLER_NAME = "controller";

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String controllerName =  request.getParameter(CONTROLLER_NAME);
        System.out.println(" Controller is: " + controllerName);
        if(controllerName == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("");

            System.out.println();
            dispatcher.forward(request, response);
            return;
        }

        ControllerFactory factory = ControllerFactory.getInstance();
        ControllerInt controller = factory.getController(controllerName);
        ViewResolver resolver = controller.resolve(request, response);
        dispatch(request, response, resolver);
    }

    private void dispatch(final HttpServletRequest request, final HttpServletResponse response,
                          final ViewResolver resolver) throws ServletException, IOException {

        System.out.println("malk");
        String view = resolver.getView();
        System.out.println(view);
        switch (resolver.getResolveAction()) {
            case FORWARD:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
                dispatcher.forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(view);
                break;
            case PLAIN_TEXT:
                response.setContentType("plain/text");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(view);
                break;
            default:
                break;
        }

    }

}
