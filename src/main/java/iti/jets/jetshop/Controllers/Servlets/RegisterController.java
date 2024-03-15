package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterController implements ControllerInt {
    private static RegisterController instance;

    private RegisterController() {}

    public static RegisterController getInstance() {
        if (instance == null) {
            instance = new RegisterController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {

        ViewResolver resolver = new ViewResolver();
        if(request.getMethod().equals("GET")) {
            //TODO: to register the path of the registration form
            resolver.forward(ViewEnum.Register.getViewPath());
        }else
        {
            Gson gson = new Gson();
            CustomerDto customerDto = gson.fromJson(request.getParameter("customer"), CustomerDto.class);
            CustomerService.register(customerDto);
            response.setStatus(201); // to indicate successful insertion
            resolver.forward(ViewEnum.Welcome.getViewPath());
        }


        return resolver;
    }

}
