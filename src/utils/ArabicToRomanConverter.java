package com.java_mentor.utils;

import com.java_mentor.interfaces.Converter;

public class ArabicToRomanConverter implements Converter<Integer,String> {
    private static final String C[] = {"", "C"};
    private static final String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    @Override
    public String convert(Integer arabicNumber) {
        String romanResult = "";
        if(arabicNumber < 0) {
            romanResult = "-";
            arabicNumber = Math.abs(arabicNumber);
        }
        String hundred = C[(arabicNumber % 1000)/100];
        String tens = X[(arabicNumber % 100)/10];
        String ones = I[arabicNumber % 10];
        romanResult += hundred + tens + ones;
        return romanResult;
    }
}
