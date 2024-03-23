package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
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
import java.util.Optional;

public class AdminEditProductController implements ControllerInt {
    private static AdminEditProductController instance;

    private AdminEditProductController() {}

    public static AdminEditProductController getInstance() {
        if (instance == null) {
            instance = new AdminEditProductController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("POST"))
        {

            String productId = request.getParameter("id");
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
            ProductDto product = new ProductDto(Integer.parseInt(productId), name, Integer.parseInt(stock), description, new BigDecimal(price), category, images);

            ProductService.updateProduct(product);

            resolver.redirect(ViewEnum.AdminProduct.getViewName());

        }else
        {
            String productId = request.getParameter("id");
            Optional<ProductDto> product = ProductService.getProductById(productId);
            List<CategoryDto> categories = CategoryService.getAllCategories();

            request.setAttribute("categories", categories);
            request.setAttribute("product", product.get());

            resolver.forward(ViewEnum.AdminEditProduct.getViewPath());
        }
        return resolver;
    }
}
