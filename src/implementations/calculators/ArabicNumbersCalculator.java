package com.java_mentor.implementations.calculators;

import com.java_mentor.enums.Operation;
import com.java_mentor.interfaces.Calculator;

public class ArabicNumbersCalculator implements Calculator<Integer> {
    @Override
    public Integer calculate(String[] parsedExpression) {
        String sign = parsedExpression[1];
        int a = Integer.valueOf(parsedExpression[0]);
        int b = Integer.valueOf(parsedExpression[2]);
        Operation operation = Operation.getInstance(sign);
        return operation.count(a, b);
    }
}
