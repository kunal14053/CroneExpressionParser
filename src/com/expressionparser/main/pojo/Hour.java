package com.expressionparser.main.pojo;

import com.expressionparser.main.constants.AnyValue;
import com.expressionparser.main.constants.Range;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

public class Hour implements Operations{
    String result;

    @Override
    public void parse(String entity) throws Exception {

        if(entity.equals("*")){
            result = AnyValue.HOUR.getDuration();
        } else if(Validate.isValidNumber(entity, Range.HOUR)){
            result = entity;
        } else if(Validate.isValidRange(entity,Range.HOUR)){
            result = StringOperations.getRange(entity);
        } else if(Validate.isValidList(entity, Range.HOUR)){
            result = StringOperations.getList(entity);
        } else if(Validate.isValidStep(entity, Range.HOUR)) {
            result = StringOperations.getSteps(entity, Range.HOUR);
        } else{
            throw new Exception("Invalid Hour");
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

    public static Hour getInstance() {
        return new Hour();
    }
}
