package com.expressionparser.main.pojo;

import com.expressionparser.main.constants.AnyValue;
import com.expressionparser.main.constants.Range;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;


public class DayOfMonth implements Operations{

    String result;

    @Override
    public void parse(String entity) throws Exception {

        if(entity.equals("*")){
            result = AnyValue.DAY_OF_MONTH.getDuration();
        } else if(Validate.isValidNumber(entity, Range.DAY_OF_MONTH)){
            result = entity;
        } else if(Validate.isValidRange(entity,Range.DAY_OF_MONTH)){
            result = StringOperations.getRange(entity);
        } else if(Validate.isValidList(entity, Range.DAY_OF_MONTH)){
            result = StringOperations.getList(entity);
        } else if(Validate.isValidStep(entity, Range.DAY_OF_MONTH)) {
            result = StringOperations.getSteps(entity, Range.DAY_OF_MONTH);
        } else{
            throw new Exception("Invalid Day of Month");
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


    public static DayOfMonth getInstance() {
        return new DayOfMonth();
    }

}
