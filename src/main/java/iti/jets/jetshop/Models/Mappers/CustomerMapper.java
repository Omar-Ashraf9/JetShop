package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Persistence.Entities.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerDto customerDto);

    CustomerDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);
}