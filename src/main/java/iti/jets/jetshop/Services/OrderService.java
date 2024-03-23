package iti.jets.jetshop.Services;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import iti.jets.jetshop.Models.DTO.OrderDto;
import iti.jets.jetshop.Models.Mappers.OrderMapper;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Repository.OrderRepo;

public class OrderService {
    public static List<OrderDto> getAllOrders() {
        return DB.doInTransaction(em -> {

            OrderRepo orderRepo = new OrderRepo(em);
            OrderMapper orderMapper = OrderMapper.INSTANCE;
            return orderRepo.findAll()
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(orderMapper ::toDto)
                    .collect(Collectors.toList());
        });
    }

    public static List<OrderDto> getOrdersByCustomerId(Integer customerId) {
        return DB.doInTransaction(em -> {
            OrderRepo orderRepo = new OrderRepo(em);
            OrderMapper orderMapper = OrderMapper.INSTANCE;
            return orderRepo.getOrdersByCustomerId(customerId)
                    .stream()
                    .map(orderMapper::toDto)
                    .collect(Collectors.toList());
        });
    }

    public static int getOrdersCount() {
        return DB.doInTransaction(em -> {
            OrderRepo orderRepo = new OrderRepo(em);
            return orderRepo.count();
        });
    }
}
