package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.OrderDto;
import iti.jets.jetshop.Persistence.Entities.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {CustomerMapper.class})
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);

    @AfterMapping
    default void linkOrdersItems(@MappingTarget Order order) {
        order.getOrdersItems().forEach(ordersItem -> ordersItem.setOrder(order));
    }

    OrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);
}