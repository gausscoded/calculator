package com.java_mentor.implementations.parsers;

import com.java_mentor.interfaces.Parser;

public class ExpressionParser implements Parser<String[]> {
    private static final String DELIMITERS = "(?<=[-+*/])|(?=[-+*/])";
    @Override
    public String[] parse(String expression) {
        String expressionWithoutSpaces = expression.replaceAll("\\s+","");
        String[] parsedExpression = expressionWithoutSpaces.split(DELIMITERS);
        return parsedExpression;
    }
}
