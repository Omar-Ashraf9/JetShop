package iti.jets.jetshop.Controllers.Filters;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import jakarta.servlet.*;

import java.io.IOException;

public class TemplateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.getRequestDispatcher(ViewEnum.Header.getViewPath()).include(request, response);
        filterChain.doFilter(request, response);
        request.getRequestDispatcher(ViewEnum.Footer.getViewPath()).include(request, response);
    }
}
