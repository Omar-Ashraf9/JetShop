package iti.jets.jetshop.Controllers.Servlets;

import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
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
        if(request.getMethod().equals("POST")) {
            try {
                BufferedReader reader = request.getReader();
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                String jsonString = sb.toString();
                Gson gson = new Gson();
                LoginDto loginDto = gson.fromJson(jsonString, LoginDto.class);

                Optional<CustomerDto> loginResult = CustomerService.login(loginDto);
                if(loginResult.isPresent())
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("customer", loginResult.get());
                    resolver.forward(ViewEnum.Welcome.getViewPath());
                } else {
                    resolver.plainText("please enter a correct email and password");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            resolver.forward(ViewEnum.Login.getViewPath());
        }
        return resolver;
    }
}