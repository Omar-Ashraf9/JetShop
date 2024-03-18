package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.ProductImageDto;
import iti.jets.jetshop.Persistence.Entities.ProductImage;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductImageMapper {
    ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);

    ProductImage toEntity(ProductImageDto productImageDto);

    ProductImageDto toDto(ProductImage productImage);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductImage partialUpdate(ProductImageDto productImageDto, @MappingTarget ProductImage productImage);
}