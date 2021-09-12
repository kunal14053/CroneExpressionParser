package com.expressionparser.main.parser;

import com.expressionparser.main.constants.enums.AnyValue;
import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

import static com.expressionparser.main.constants.Constants.WILDCARD;


public class DayOfMonthParser implements Parser {

    private DayOfMonthParser(){}
    private static final DayOfMonthParser obj = new DayOfMonthParser();
    public static DayOfMonthParser getInstance() {
        return obj;
    }

    @Override
    public String parse(InputExpression expression) throws Exception {
        String entity = expression.getDayOfMonth();
        try {
            String result;
            if (entity.equals(WILDCARD)) {
                result = AnyValue.DAY_OF_MONTH.getDuration();
            } else if (Validate.isValidNumber(entity, Range.DAY_OF_MONTH)) {
                result = entity;
            } else if (Validate.isValidRange(entity, Range.DAY_OF_MONTH)) {
                result = StringOperations.getRange(entity);
            } else if (Validate.isValidList(entity, Range.DAY_OF_MONTH)) {
                result = StringOperations.getList(entity);
            } else if (Validate.isValidStep(entity, Range.DAY_OF_MONTH)) {
                result = StringOperations.getSteps(entity, Range.DAY_OF_MONTH);
            } else {
                throw new Exception("Invalid Day of Month");
            }
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
