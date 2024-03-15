package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.CategoryDto;
import iti.jets.jetshop.Persistence.Entities.Category;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);

    @AfterMapping
    default void linkProducts(@MappingTarget Category category) {
        category.getProducts().forEach(product -> product.setCategory(category));
    }

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);
}