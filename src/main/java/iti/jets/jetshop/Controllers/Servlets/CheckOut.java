package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.Mappers.CustomerMapper;
import iti.jets.jetshop.Services.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckOut implements ControllerInt {
    private static CheckOut instance;

    private CheckOut() {
    }

    public static CheckOut getInstance() {
        if (instance == null) {
            instance = new CheckOut();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
            HttpSession session = request.getSession(false);
            CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
            if(customerDto==null){
                resolver.forward(ViewEnum.Login.getViewPath());
            }
            else{
                String checkout = CartService.checkout(customerDto);
                System.out.println(checkout);
                if(checkout.equals("success")){
                    //checkout done
                    resolver.plainText(checkout);
                }
                else{
                    resolver.plainText(checkout);
                }


            }


        }
        return resolver;
    }

}
