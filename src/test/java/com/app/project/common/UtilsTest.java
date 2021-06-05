package com.app.project.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    private final String PREFIX_ONE = "\\(256\\)\\ ?\\d{9}$";
    private final String PREFIX_TWO = "\\(251\\)\\ ?[1-59]\\d{8}$";

    @Test
    void verifyPrefix() {
        String CORRECT_PHONE = "(256) 704244430";
        boolean validNumber = Utils.verifyPrefix(CORRECT_PHONE, PREFIX_ONE);
        boolean notValidNumber = Utils.verifyPrefix(CORRECT_PHONE, PREFIX_TWO);

        assertTrue(validNumber);
        assertFalse(notValidNumber);
    }

    @Test
    void extractCountryCode() {
        String countryCode = Utils.extractCountryCode(PREFIX_ONE);
        assertEquals(countryCode, "256");
        countryCode = Utils.extractCountryCode(PREFIX_TWO);
        assertNotEquals(countryCode, "256");
        assertEquals(countryCode, "251");
    }
}