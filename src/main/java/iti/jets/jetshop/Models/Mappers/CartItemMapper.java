package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.CartItemDto;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductMapper.class})
public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);
    CartItem toEntity(CartItemDto cartItemDto);

    CartItemDto toDto(CartItem cartItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CartItem partialUpdate(CartItemDto cartItemDto, @MappingTarget CartItem cartItem);
}