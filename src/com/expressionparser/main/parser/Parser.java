package com.expressionparser.main.parser;


import com.expressionparser.main.domain.InputExpression;

public interface Parser {
    String parse(InputExpression expression) throws Exception;
}
