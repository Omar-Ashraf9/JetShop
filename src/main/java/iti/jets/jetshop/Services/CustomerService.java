package iti.jets.jetshop.Services;


import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Models.Mappers.CustomerMapper;
import iti.jets.jetshop.Models.Mappers.CustomerMapperImpl;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;

import java.util.Optional;


public class CustomerService {
    public static void register(CustomerDto customerDto){
        DB.doInTransactionWithoutResult(em -> {
            CustomerRepo customerRepo = new CustomerRepo(em);
            CustomerMapper mapper =CustomerMapper.INSTANCE;
            Customer customer = mapper.toEntity(customerDto);
            customerRepo.create(customer);
        });
    }

    public static boolean isEmailFound(String email){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = customerRepo.getCustomerByEmail(email);
            if(customer.isPresent())
                return true;
            else
                return false;
        });
    }

    public static Optional<CustomerDto> isCustomerFound(Integer id){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<CustomerDto> customer = customerRepo.findById(id).map(CustomerMapperImpl.INSTANCE::toDto);
            if(customer.isPresent())
                return  customer;
            else
                return Optional.empty();
        });

    }
    public static Optional<CustomerDto> login(LoginDto loginDto){
        if(isEmailFound(loginDto.getEmail()))
        {
            return DB.doInTransaction(em -> {
                CustomerRepo customerRepo = new CustomerRepo(em);
                Optional<Customer> customer = customerRepo.getCustomerByEmail(loginDto.getEmail());

                if(customer.isPresent() && customer.get().getPassword().equals(loginDto.getPassword()))
                {
                    CustomerMapper customerMapper = CustomerMapper.INSTANCE;
                    return Optional.of(customerMapper.toDto(customer.get()));
                }
                else{
                    return Optional.empty();
                }
            });
        } else
        {
            return Optional.empty();
        }
    }
    public static Optional<CustomerDto> updateCustomerProfile(Customer newCustomer){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            return customerRepo.update(newCustomer).map(CustomerMapperImpl.INSTANCE::toDto);
        });
    }
}
