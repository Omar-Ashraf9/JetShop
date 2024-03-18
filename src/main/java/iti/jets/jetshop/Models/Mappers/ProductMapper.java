package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Persistence.Entities.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDto productDto);

    @AfterMapping
    default void linkProductImages(@MappingTarget Product product) {
        product.getProductImages().forEach(productImage -> productImage.setProduct(product));
    }

    @Mapping(source = "category", target = "category", qualifiedByName = "toDtoMethod")
    ProductDto toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductDto productDto, @MappingTarget Product product);
}