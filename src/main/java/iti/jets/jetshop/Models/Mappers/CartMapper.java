package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.CartDto;
import iti.jets.jetshop.Persistence.Entities.Cart;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CustomerMapper.class, CartItemMapper.class})
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    Cart toEntity(CartDto cartDto);

    @AfterMapping
    default void linkCartItems(@MappingTarget Cart cart) {
        cart.getCartItems().forEach(cartItem -> cartItem.setCart(cart));
    }

    CartDto toDto(Cart cart);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartDto cartDto, @MappingTarget Cart cart);
}