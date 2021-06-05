package com.app.project.common;

import com.app.project.model.Customer;
import com.app.project.model.PhoneUI;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = PhoneMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
@Component
public interface PhoneMapper {

    @Mapping(target = "countryName", source = "countryName")
    @Mapping(target = "countryCode", expression = "java(Utils.extractCountryCode(countryCode))")
    @Mapping(target = "validState", expression = "java(Utils.verifyPrefix(customer.phone, countryCode))")
    @Mapping(target = "phoneNumber", source = "customer.phone")
    @Mapping(target = "customerName", source = "customer.name")
    PhoneUI entityToUI(String countryCode, String countryName, Customer customer);

}
