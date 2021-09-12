package com.expressionparser.main.parser;

import com.expressionparser.main.constants.enums.AnyValue;
import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

import static com.expressionparser.main.constants.Constants.WILDCARD;

public class Minute implements Parser {

    private Minute() { }
    private static final Minute obj = new Minute();
    public static Minute getInstance() {
        return obj;
    }

    @Override
    public String parse(InputExpression expression) throws Exception {
        try {
            String result;
            String entity = expression.getMinutes();
            if(entity.equals(WILDCARD)){
                result = AnyValue.MINUTES.getDuration();
            } else if(Validate.isValidNumber(entity, Range.MINUTE)){
                result = entity;
            } else if(Validate.isValidRange(entity,Range.MINUTE)){
                result = StringOperations.getRange(entity);
            } else if(Validate.isValidList(entity, Range.MINUTE)){
                result = StringOperations.getList(entity);
            } else if(Validate.isValidStep(entity, Range.MINUTE)) {
                result = StringOperations.getSteps(entity, Range.MINUTE);
            } else{
                throw new Exception("Invalid Minute");
            }
            return result;
        } catch (Exception e){
            throw e;
        }
    }
}
