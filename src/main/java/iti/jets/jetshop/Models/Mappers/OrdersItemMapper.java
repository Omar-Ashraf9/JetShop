package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.OrdersItemDto;
import iti.jets.jetshop.Persistence.Entities.OrdersItem;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {OrderMapper.class, ProductMapper.class})
public interface OrdersItemMapper {
    OrdersItem toEntity(OrdersItemDto ordersItemDto);

    OrdersItemDto toDto(OrdersItem ordersItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrdersItem partialUpdate(OrdersItemDto ordersItemDto, @MappingTarget OrdersItem ordersItem);
}