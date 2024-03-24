package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.*;
import iti.jets.jetshop.Persistence.Entities.Cart;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Services.CartService;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LoginController implements ControllerInt {
    private static LoginController instance;

    private LoginController() {
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            LoginDto loginDto = new LoginDto(password, email);
            Optional<CustomerDto> loginResult = CustomerService.login(loginDto);
            Gson gson = new Gson();
            if (loginResult.isPresent()) {
                CustomerDto customerDto = loginResult.get();
                HttpSession session = request.getSession(true);
                session.setAttribute("customer", customerDto);
                CartDto cart = CartService.getCartFromCustomerId(customerDto.getId());
                String productIdsJson = request.getParameter("productIds");
                String QuantitiesJson = request.getParameter("quantities");
                // Parse productIds JSON string to int array using Gson

                Integer[] productIds = gson.fromJson(productIdsJson, Integer[].class);
                int[] quantities = gson.fromJson(QuantitiesJson, int[].class);
                // Parse productIds to int array
                if (cart == null) {
                    CartService.createCart(customerDto);
                    //add All products to cartItems table -> addProductToCart(Integer productId,Integer customerId)
                    // for All Products
                    if (productIds != null) {
                        for (int productId : productIds) {
                            CartService.addProductToCart(productId, customerDto.getId());
                        }
                    }
                } else {
                    List<ProductWithQuantityDto> productsNotInLocalStorage;
                    // already have cart
                    // cartId + prouctID and check if this cartItem with these ids is exist
                    // if exist update quantity of this cartItem
                    if (productIds != null) {
                        for (int i = 0; i < productIds.length; i++) {
                            CartService.editQuantityOrAddIfNotExist(cart.getId(), productIds[i], customerDto.getId(), quantities[i]);
                        }
                        productsNotInLocalStorage  = CartService.retrieveCartItemNotExistInLocalStorage(cart.getId(), productIds);

                    }else {
                      productsNotInLocalStorage = CartService.retrieveProductWithQuantityDto(cart.getId());

                    }
                    String cartItemsNotInLocalStorageJson = gson.toJson(productsNotInLocalStorage);
                    System.out.println("cartItemsNotInLocalStorageJson " + cartItemsNotInLocalStorageJson);
                    // Set the appropriate content type and character encoding
                    System.out.println("write Json");
                    resolver.plainText(cartItemsNotInLocalStorageJson);
                }
                //resolver.forward(ViewEnum.Home.getViewPath()); //TODO
            } else {
                resolver.plainText(gson.toJson("please enter a correct email and password"));
            }

        } else {
            System.out.println("login controller");
            resolver.forward(ViewEnum.Login.getViewPath());
        }
        return resolver;
    }
}