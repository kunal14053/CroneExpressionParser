package com.expressionparser.main.service;

import com.expressionparser.main.constants.Range;
import com.expressionparser.main.dto.InputExpression;
import com.expressionparser.main.dto.OutputExpression;
import com.expressionparser.main.utils.StringOperations;


public class ExpressionParser {

    private ExpressionParser(){}

    public static ExpressionParser getExpressionParserInstance(){
        return new ExpressionParser();
    }

    public String returnOutputExpression(String expression) throws Exception {
        try {
            InputExpression inputExpression = StringOperations.getExpressionObject(expression);
            OutputExpression outputExpression = new OutputExpression();
            parseExpression(inputExpression, outputExpression);
            return outputExpression.toString();
        } catch (Exception e){
            throw e;
        }
    }

    private void parseExpression(InputExpression inputExpression , OutputExpression outputExpression) throws Exception {
        try {
            ParserFactory parserFactory = ParserFactory.getInstance();
            outputExpression.setCommand(parserFactory.getResult(Range.COMMAND, inputExpression));
            outputExpression.setMinutes(parserFactory.getResult(Range.MINUTE, inputExpression));
            outputExpression.setHours(parserFactory.getResult(Range.HOUR, inputExpression));
            outputExpression.setDayOfMonth(parserFactory.getResult(Range.DAY_OF_MONTH, inputExpression));
            outputExpression.setMonth(parserFactory.getResult(Range.MONTH, inputExpression));
            outputExpression.setDayOfWeek(parserFactory.getResult(Range.DAY_OF_WEEK, inputExpression));
        } catch (Exception e){
            throw e;
        }
    }
}
