package iti.jets.jetshop.Controllers.Servlets;

import com.google.gson.Gson;
import iti.jets.jetshop.Controllers.Enums.ViewEnum;
import iti.jets.jetshop.Controllers.FrontController.ControllerInt;
import iti.jets.jetshop.Controllers.FrontController.ViewResolve.ViewResolver;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

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
            HttpSession session = request.getSession(false);
            if(session.getAttribute("customer")==null){
                resolver.forward(ViewEnum.Register.getViewPath());
            }
            else{
                resolver.forward(ViewEnum.Account.getViewPath());
            }

        }else
        {

            try {
                // Read the request's input stream
                BufferedReader reader = request.getReader();
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                String jsonString = sb.toString();

                // Log the JSON string
                System.out.println("Received JSON string: " + jsonString);

                // Parse the JSON string to a CustomerDto object
                Gson gson = new Gson();
                CustomerDto customerDto = gson.fromJson(jsonString, CustomerDto.class);

                // Log the CustomerDto object
                System.out.println("Parsed CustomerDto: " + customerDto);

                // Continue with your logic
                CustomerService.register(customerDto);
                response.setStatus(201); // to indicate successful insertion
//                HttpSession session = request.getSession(true);
//                session.setAttribute("customer", customerDto);
                //resolver.forward(ViewEnum.Login.getViewName());
                resolver.plainText("success");
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return resolver;
    }

}
