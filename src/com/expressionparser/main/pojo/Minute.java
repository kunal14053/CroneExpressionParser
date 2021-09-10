package com.expressionparser.main.pojo;

import com.expressionparser.main.constants.AnyValue;
import com.expressionparser.main.constants.Range;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

public class Minute implements Operations{
    String result;

    @Override
    public void parse(String entity) throws Exception {

        if(entity.equals("*")){
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
    }

    @Override
    public String getResult(String entity) throws Exception {
        try {
            parse(entity);
            return result;
        } catch (Exception e){
            throw e;
        }
    }

    public static Minute getInstance() {
        return new Minute();
    }
}
