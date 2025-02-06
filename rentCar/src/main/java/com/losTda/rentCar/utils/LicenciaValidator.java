package com.losTda.rentCar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicenciaValidator {
    private static final String PATTERN = "^[A-Z]{1}[0-9]{9}$";

    public static boolean esLicenciaValida(String codigo) {
        if (codigo == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(codigo);
        return matcher.matches();
    }
}
