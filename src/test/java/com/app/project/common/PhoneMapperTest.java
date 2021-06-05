package com.app.project.common;

import com.app.project.model.Customer;
import com.app.project.model.PhoneUI;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PhoneMapperTest {

    PhoneMapper phoneMapper = Mappers.getMapper(PhoneMapper.class);

    @Test
    void entityToUI() {
        Customer customer = new Customer(10, "DummyCustomer", "(256) 6540160540");
        String countryCode = "256";
        String countryName = "Uganda";
        PhoneUI phoneUI = phoneMapper.entityToUI(countryCode, countryName, customer);

        assertNotNull(phoneUI);
        assertEquals(phoneUI.getPhoneNumber(), customer.getPhone());

    }


}