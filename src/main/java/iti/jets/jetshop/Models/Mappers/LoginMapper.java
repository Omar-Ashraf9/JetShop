package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Persistence.Entities.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginMapper {
    LoginMapper INSTANCE = Mappers.getMapper(LoginMapper.class);

    Customer toEntity(LoginDto loginDto);

    LoginDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(LoginDto loginDto, @MappingTarget Customer customer);
}