package com.app.project.controller;


import com.app.project.model.PhoneUI;
import com.app.project.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/getAllPhones")
    public List<PhoneUI> findAllPhones(Pageable pageable) {
        return phoneService.getAllPhones();
    }


}
