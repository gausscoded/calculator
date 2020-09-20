package com.java_mentor.implementations.calculators;

import com.java_mentor.enums.Operation;
import com.java_mentor.interfaces.Calculator;
import com.java_mentor.interfaces.Converter;
import com.java_mentor.utils.ArabicToRomanConverter;
import com.java_mentor.utils.RomanToArabicConverter;

public class RomanNumbersCalculator implements Calculator<String> {
    @Override
    public String calculate(String[] parsedExpression) {
        String sign = parsedExpression[1];
        Converter<String,Integer> romanToArabicConverter = new RomanToArabicConverter();
        int a = romanToArabicConverter.convert(parsedExpression[0]);
        int b = romanToArabicConverter.convert(parsedExpression[2]);
        Operation operation = Operation.getInstance(sign);
        int result = operation.count(a, b);
        Converter<Integer,String> arabicToRomanConverter = new ArabicToRomanConverter();
        String romanResult = arabicToRomanConverter.convert(result);
        return romanResult;
    }
}
