package com.app.project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class Country {

    public Map<String, String> countries = Map.of(
            "Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$",
            "Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$",
            "Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$",
            "Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$",
            "Uganda", "\\(256\\)\\ ?\\d{9}$"
    );

    public Map<String, String> getCountries() {
        return countries;
    }
}

