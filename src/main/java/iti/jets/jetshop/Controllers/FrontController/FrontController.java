package iti.jets.jetshop.Controllers.FrontController;

import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String controllerName = request.getParameter(CONTROLLER_NAME);
        System.out.println(" Controller is: " + controllerName);
        System.out.println(request.getRequestURI());
        if (controllerName == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/View/Html/index.jsp");
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

        String view = resolver.getView();
        if (request.getSession(false) != null)
            System.out.println("session " + request.getSession(false).getId());
        switch (resolver.getResolveAction()) {
            case FORWARD:
                System.out.println(view);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
                response.setContentType("text/html");
                dispatcher.forward(request, response);
                break;
            case REDIRECT:
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/front?controller=" + view);
                System.out.println("redirecting to "+contextPath + "/front?controller=" + view);
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
