package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.CategoryDto;
import iti.jets.jetshop.Persistence.Entities.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);
    @Named("toDtoMethod")
    default CategoryDto toDtoMethod (Category category){
       return toDto(category);
    };
}