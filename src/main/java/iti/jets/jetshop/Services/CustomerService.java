package iti.jets.jetshop.Services;


import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Models.Mappers.CustomerMapper;
import iti.jets.jetshop.Models.Mappers.CustomerMapperImpl;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public static Optional<CustomerDto> updateCustomerProfile(CustomerDto newCustomer){
        return DB.doInTransaction(em ->{
            System.out.println("pleassssssssssssse");
            CustomerRepo customerRepo = new CustomerRepo(em);
            System.out.println(newCustomer);
            return Optional.of(CustomerMapper.INSTANCE.toDto(customerRepo.update(CustomerMapper.INSTANCE.toEntity(newCustomer)).get()));
        });
    }

    public static Optional<Integer> getCartIdByCustomerId(Integer customerId) {
        return DB.doInTransaction(em -> {
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customerOptional = customerRepo.findById(customerId);
            if (customerOptional.isPresent()) {
                Customer customer = customerOptional.get();
                // Assuming there's a method to get the cartId from the customer entity
                Integer cartId = customer.getCart().getId(); // Adjust this according to your actual entity structure
                return Optional.of(cartId);
            } else {
                return Optional.empty(); // Customer not found
            }
        });
    }

    public static List<CustomerDto> getAllCustomers(){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            List<Customer> customers = customerRepo.findAll().get();
            if(customers.isEmpty())
                return null;
            return customers.stream().map(CustomerMapperImpl.INSTANCE::toDto).collect(Collectors.toList());
        });
    }

    public static CustomerDto getCustomerById(Integer id){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = customerRepo.findById(id);
            if(customer.isPresent())
                return CustomerMapperImpl.INSTANCE.toDto(customer.get());
            else
                return null;
        });
    }

    public static int getCustomersCount(){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            return customerRepo.count();
        });
    }
}
