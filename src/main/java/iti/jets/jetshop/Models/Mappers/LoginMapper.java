package iti.jets.jetshop.Models.Mappers;

import iti.jets.jetshop.Models.DTO.LoginDto;
import iti.jets.jetshop.Persistence.Entities.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface LoginMapper {
    Customer toEntity(LoginDto loginDto);

    LoginDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(LoginDto loginDto, @MappingTarget Customer customer);
}