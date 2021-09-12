package com.expressionparser.main.parser;

import com.expressionparser.main.constants.enums.AnyValue;
import com.expressionparser.main.constants.Constants;
import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;
import static com.expressionparser.main.constants.Constants.WILDCARD;

public class Month implements Parser {

    private Month() { }
    private static final Month obj = new Month();
    public static Month getInstance() {
        return obj;
    }

    @Override
    public String parse(InputExpression expression) throws Exception {
        try {
            String result;
            String entity = expression.getMonth();
            if (entity.equals(WILDCARD)) {
                result = AnyValue.MONTH.getDuration();
            } else if (Validate.isValidNumber(entity, Range.MONTH)) {
                result = entity;
            } else if (Validate.isValidRange(entity, Range.MONTH)) {
                result = StringOperations.getRange(entity);
            } else if (Validate.isValidList(entity, Range.MONTH)) {
                result = StringOperations.getList(entity);
            } else if (Validate.isValidStep(entity, Range.MONTH)) {
                result = StringOperations.getSteps(entity, Range.MONTH);
            } else if (Validate.isValidMonth(entity.toUpperCase())) {
                result = String.valueOf(Constants.MONTH.indexOf(entity.toUpperCase()));
            } else {
                throw new Exception("Invalid Month");
            }
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
