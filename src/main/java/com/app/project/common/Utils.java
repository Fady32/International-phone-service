package com.app.project.common;


import java.util.regex.Pattern;

public class Utils {

    public static boolean verifyPrefix(String phoneNumber, String prefix) {
        return Pattern.compile(prefix).matcher(phoneNumber).matches();
    }

    public static String extractCountryCode(String prefix) {
        return prefix.contains("(") && prefix.contains(")") ? prefix.substring(prefix.indexOf("(")+1, prefix.indexOf(")")-1) : "";
    }

}
