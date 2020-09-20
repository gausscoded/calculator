package com.java_mentor;

import com.java_mentor.implementations.calculators.ArabicNumbersCalculator;
import com.java_mentor.implementations.calculators.RomanNumbersCalculator;
import com.java_mentor.implementations.parsers.ExpressionParser;
import com.java_mentor.exceptions.ExpressionException;
import com.java_mentor.interfaces.Calculator;
import com.java_mentor.interfaces.Parser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        inputCheck(expression);
        Parser<String[]> parser = new ExpressionParser();
        String[] parsedExpression = parser.parse(expression);
        Character calculatorTypeIdentifier = parsedExpression[0].charAt(0);
        Calculator calculator = Character.isLetter(calculatorTypeIdentifier)
                ? new RomanNumbersCalculator()
                : new ArabicNumbersCalculator();
        String result = calculator.calculate(parsedExpression).toString();
        System.out.println(result);
    }

    private static void inputCheck(String input) {
        String regEx = "^(([1-9]|1[0])\\s*[+|\\-|/|*]\\s*([1-9]|1[0])$)" +
                "|^(X{0,1}|(IX|IV|V?I{0,3}))\\s*[+|\\-|/|*]\\s*(X{0,1}|(IX|IV|V?I{0,3}))$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new ExpressionException("Wrong expression: " + input);
        }
    }
}
