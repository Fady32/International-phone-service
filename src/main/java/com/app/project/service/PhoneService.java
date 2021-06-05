package com.app.project.service;


import com.app.project.Repository.CustomerRepository;
import com.app.project.common.PhoneMapper;
import com.app.project.common.Utils;
import com.app.project.model.Country;
import com.app.project.model.Customer;
import com.app.project.model.PhoneUI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {

    public final CustomerRepository customerRepository;

    public final PhoneMapper phoneMapper;

    private final Country country = new Country();

    public PhoneService(CustomerRepository customerRepository, PhoneMapper phoneMapper) {
        this.customerRepository = customerRepository;
        this.phoneMapper = phoneMapper;
    }


    public List<PhoneUI> getAllPhones() {
        Iterable<Customer> customers = customerRepository.findAll();

        List<PhoneUI> phoneList = new ArrayList<>();

        for (Customer customer : customers) {
            country.getCountries().entrySet().stream().filter(country -> customer.getPhone().contains(Utils.extractCountryCode(country.getValue())))
                    .findFirst().ifPresent(
                    phoneCountry -> phoneList.add(phoneMapper.entityToUI(phoneCountry.getValue(), phoneCountry.getKey(), customer))
            );
        }

        return phoneList;
    }


}
