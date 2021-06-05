package com.app.project.service;

import com.app.project.common.PhoneMapper;
import com.app.project.common.Utils;
import com.app.project.model.Country;
import com.app.project.model.Customer;
import com.app.project.model.PhoneUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class PhoneServiceTest {

    @Autowired
    PhoneService phoneService;

    private final Country country = new Country();

    @Mock
    PhoneMapper phoneMapper;


    @Test
    void getAllPhones() {

        Iterable<Customer> customers = phoneService.customerRepository.findAll();

        List<PhoneUI> phoneList = new ArrayList<>();

        for (Customer customer : customers) {
            country.getCountries().entrySet().stream().filter(country -> customer.getPhone().contains(Utils.extractCountryCode(country.getValue())))
                    .findFirst().ifPresent(
                    phoneCountry -> phoneList.add(phoneMapper.entityToUI(phoneCountry.getValue(), phoneCountry.getKey(), customer))
            );
        }

        assertFalse(phoneList.isEmpty());
        assertEquals(StreamSupport.stream(customers.spliterator(),false).count(), phoneList.size());
    }
}