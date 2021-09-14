package com.expressionparser.main.service;

import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.domain.OutputExpression;
import com.expressionparser.main.parser.factory.ParserFactory;
import com.expressionparser.main.utils.Validate;

import static com.expressionparser.main.constants.Constants.INVALID_EXPRESSION;
import static com.expressionparser.main.domain.InputExpression.getInputExpression;


public class ExpressionParseService {
    private static final ExpressionParseService obj = new ExpressionParseService();

    private ExpressionParseService() {
    }

    public static ExpressionParseService getInstance() {
        return obj;
    }


    public String parse(String inputExpression) {

        if (Validate.validateInputString(inputExpression)) {
            try {
                OutputExpression output = getOutputExpression(getInputExpression(inputExpression));
                return output.toString();
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
                return INVALID_EXPRESSION;
            }
        } else {
            return INVALID_EXPRESSION;
        }
    }

    private OutputExpression getOutputExpression(InputExpression inputExpression) throws Exception {
        try {
            OutputExpression outputExpression = new OutputExpression();
            ParserFactory parserFactory = ParserFactory.getInstance();
            outputExpression.setCommand(parserFactory.getParser(Range.COMMAND).parse(inputExpression));
            outputExpression.setMinutes(parserFactory.getParser(Range.MINUTE).parse(inputExpression));
            outputExpression.setHours(parserFactory.getParser(Range.HOUR).parse(inputExpression));
            outputExpression.setDayOfMonth(parserFactory.getParser(Range.DAY_OF_MONTH).parse(inputExpression));
            outputExpression.setMonth(parserFactory.getParser(Range.MONTH).parse(inputExpression));
            outputExpression.setDayOfWeek(parserFactory.getParser(Range.DAY_OF_WEEK).parse(inputExpression));
            return outputExpression;
        } catch (Exception e) {
            throw e;
        }
    }
}
