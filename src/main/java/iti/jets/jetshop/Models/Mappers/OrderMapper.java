package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.OrderDto;
import iti.jets.jetshop.Persistence.Entities.Order;
import iti.jets.jetshop.Persistence.Entities.OrdersItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDto orderDto);

    @Mapping(target = "amount", expression = "java(calculateOrderAmount(order))")
    OrderDto toDto(Order order);

    default BigDecimal calculateOrderAmount(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrdersItem ordersItem : order.getOrdersItems()) {
            totalAmount = totalAmount.add(ordersItem.getAmount());
        }
        return totalAmount;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);
}