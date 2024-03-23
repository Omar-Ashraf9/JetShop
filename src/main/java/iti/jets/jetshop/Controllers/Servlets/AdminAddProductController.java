package iti.jets.jetshop.Controllers.Servlets;


import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CategoryDto;
import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Models.DTO.ProductImageDto;
import iti.jets.jetshop.Services.CategoryService;
import iti.jets.jetshop.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.List;

public class AdminAddProductController implements ControllerInt {
    private static AdminAddProductController instance;

    private AdminAddProductController() {}

    public static AdminAddProductController getInstance() {
        if (instance == null) {
            instance = new AdminAddProductController();
        }
        return instance;
    }


    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST"))
        {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String categoryId = request.getParameter("category");
            String price = request.getParameter("price");
            String stock = request.getParameter("stock");
            String image1 = request.getParameter("image1");
            String image2 = request.getParameter("image2");
            String image3 = request.getParameter("image3");

            List<ProductImageDto> images = List.of(new ProductImageDto(null, image1), new ProductImageDto(null, image2), new ProductImageDto(null, image3));

            // Get the category by its ID
            CategoryDto category = CategoryService.getCategoryById(Integer.parseInt(categoryId));

            // Construct the Product DTO
            ProductDto product = new ProductDto(null, name, Integer.parseInt(stock), description, new BigDecimal(price), category, images);

            ProductService.addProduct(product);

            resolver.redirect(ViewEnum.AdminProduct.getViewName());


        }else
        {
            List<CategoryDto> categories = CategoryService.getAllCategories();
            for (CategoryDto category : categories) {
                System.out.println(category.getCategoryName());
            }
            request.setAttribute("allCategories", categories);
            resolver.forward(ViewEnum.AdminAddProduct.getViewPath());

        }
        return resolver;
    }
}
