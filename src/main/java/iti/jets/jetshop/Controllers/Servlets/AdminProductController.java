package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CategoryDto;
import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Services.CategoryService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class AdminProductController implements ControllerInt {
    private static AdminProductController instance;

    private AdminProductController() {}

    public static AdminProductController getInstance() {
        if (instance == null) {
            instance = new AdminProductController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST"))
        {

        }else
        {
            List<ProductDto> allProducts = ProductService.getAllProducts();
            List<CategoryDto> allCategories = CategoryService.getAllCategories();
            request.setAttribute("products", allProducts);
            request.setAttribute("categories", allCategories);
            resolver.forward(ViewEnum.AdminProduct.getViewPath());
        }
        return resolver;
    }
}
