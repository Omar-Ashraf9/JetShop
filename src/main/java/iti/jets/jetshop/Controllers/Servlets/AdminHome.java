package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CategoryDto;
import iti.jets.jetshop.Models.DTO.OrderDto;
import iti.jets.jetshop.Services.CategoryService;
import iti.jets.jetshop.Services.CustomerService;
import iti.jets.jetshop.Services.OrderService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AdminHome implements ControllerInt {
    private static AdminHome instance;

    private AdminHome() {}

    public static AdminHome getInstance() {
        if (instance == null) {
            instance = new AdminHome();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        List<OrderDto> orders = OrderService.getAllOrders();

        int numOfCustomers = CustomerService.getCustomersCount();
        int numOfProducts = ProductService.getProductsCount();
        int numOfOrders = OrderService.getOrdersCount();

        Map<String, Integer> stats = new HashMap<>();
        stats.put("numOfCustomers", numOfCustomers);
        stats.put("numOfProducts", numOfProducts);
        stats.put("numOfOrders", numOfOrders);


        request.setAttribute("orders", orders);
        request.setAttribute("stats", stats);
        ViewResolver resolver = new ViewResolver();
        resolver.forward(ViewEnum.AdminHome.getViewPath());
        return resolver;
    }
}
