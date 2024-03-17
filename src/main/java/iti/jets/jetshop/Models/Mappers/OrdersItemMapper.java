package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.OrdersItemDto;
import iti.jets.jetshop.Persistence.Entities.OrdersItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdersItemMapper {
    OrdersItemMapper INSTANCE = Mappers.getMapper(OrdersItemMapper.class);

    OrdersItem toEntity(OrdersItemDto ordersItemDto);

    OrdersItemDto toDto(OrdersItem ordersItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrdersItem partialUpdate(OrdersItemDto ordersItemDto, @MappingTarget OrdersItem ordersItem);
}