package com.app.project.controller;

import com.app.project.Repository.CustomerRepository;
import com.app.project.model.Customer;
import com.app.project.model.PhoneUI;
import com.app.project.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PhoneControllerTest {

    @InjectMocks
   private PhoneService phoneService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void findAllPhones() {
        Iterable<Customer> customers = new ArrayList<>();
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        List<PhoneUI> allPhones = phoneService.getAllPhones();
        assertTrue(allPhones.isEmpty());
    }
}