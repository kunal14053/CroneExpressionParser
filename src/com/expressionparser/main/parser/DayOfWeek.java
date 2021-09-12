package com.expressionparser.main.parser;

import com.expressionparser.main.constants.enums.AnyValue;
import com.expressionparser.main.constants.Constants;
import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

public class DayOfWeek implements Parser {

    private DayOfWeek(){}
    private static final DayOfWeek obj = new DayOfWeek();
    public static DayOfWeek getInstance() {
        return obj;
    }

    @Override
    public String parse(InputExpression expression) throws Exception {
        try {
            String result;
            String entity = expression.getDayOfWeek();
            if (entity.equals("*")) {
                result = AnyValue.DAY_OF_WEEK.getDuration();
            } else if (Validate.isValidNumber(entity, Range.DAY_OF_WEEK)) {
                result = entity;
            } else if (Validate.isValidRange(entity, Range.DAY_OF_WEEK)) {
                result = StringOperations.getRange(entity);
            } else if (Validate.isValidList(entity, Range.DAY_OF_WEEK)) {
                result = StringOperations.getList(entity);
            } else if (Validate.isValidStep(entity, Range.DAY_OF_WEEK)) {
                result = StringOperations.getSteps(entity, Range.DAY_OF_WEEK);
            } else if (Validate.isValidDayOfWeek(entity.toUpperCase())) {
                result = String.valueOf(Constants.DAYS_OF_WEEK.indexOf(entity.toUpperCase()));
            } else {
                throw new Exception("Invalid Day of Week");
            }
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
