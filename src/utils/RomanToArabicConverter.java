package com.java_mentor.utils;

import com.java_mentor.enums.RomanNumber;
import com.java_mentor.interfaces.Converter;

public class RomanToArabicConverter implements Converter<String,Integer>{
    @Override
    public Integer convert(String romanNumber) {
       int result = 0;
       int lastNumber = 0;
       for(int i = romanNumber.length() - 1; i >= 0; i--) {
           RomanNumber number = RomanNumber.valueOf(Character.valueOf(romanNumber.charAt(i)).toString());
           result = countResult(number.getValue(), lastNumber, result);
           lastNumber = number.getValue();
       }
       return result;
   }

    private static int countResult(int currentNumber, int lastNumber, int result) {
        if (lastNumber > currentNumber) {
            return result - currentNumber;
        } else {
            return result + currentNumber;
        }
    }
}
