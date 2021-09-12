package com.expressionparser.main.parser;

import com.expressionparser.main.constants.enums.AnyValue;
import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

import static com.expressionparser.main.constants.Constants.WILDCARD;

public class Hour implements Parser {

    private Hour() { }
    private static final Hour obj = new Hour();
    public static Hour getInstance() {
        return obj;
    }

    @Override
    public String parse(InputExpression expression) throws Exception {
        try {
            String result;
            String entity = expression.getHours();
            if (entity.equals(WILDCARD)) {
                result = AnyValue.HOUR.getDuration();
            } else if (Validate.isValidNumber(entity, Range.HOUR)) {
                result = entity;
            } else if (Validate.isValidRange(entity, Range.HOUR)) {
                result = StringOperations.getRange(entity);
            } else if (Validate.isValidList(entity, Range.HOUR)) {
                result = StringOperations.getList(entity);
            } else if (Validate.isValidStep(entity, Range.HOUR)) {
                result = StringOperations.getSteps(entity, Range.HOUR);
            } else {
                throw new Exception("Invalid Hour");
            }
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
