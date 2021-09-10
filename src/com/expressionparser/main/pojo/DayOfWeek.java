package com.expressionparser.main.pojo;

import com.expressionparser.main.constants.AnyValue;
import com.expressionparser.main.constants.Other;
import com.expressionparser.main.constants.Range;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

public class DayOfWeek implements Operations{
    String result;

    @Override
    public void parse(String entity) throws Exception {

        if(entity.equals("*")){
            result = AnyValue.DAY_OF_WEEK.getDuration();
        } else if(Validate.isValidNumber(entity, Range.DAY_OF_WEEK)){
            result = entity;
        } else if(Validate.isValidRange(entity,Range.DAY_OF_WEEK)){
            result = StringOperations.getRange(entity);
        } else if(Validate.isValidList(entity, Range.DAY_OF_WEEK)){
            result = StringOperations.getList(entity);
        } else if(Validate.isValidStep(entity, Range.DAY_OF_WEEK)) {
            result = StringOperations.getSteps(entity, Range.DAY_OF_WEEK);
        } else if(Validate.isValidDayOfWeek(entity.toUpperCase())){
            result = String.valueOf(Other.DAYS_OF_WEEK.indexOf(entity.toUpperCase()));
        }
        else{
            throw new Exception("Invalid Day of Week");
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


    public static DayOfWeek getInstance() {
        return new DayOfWeek();
    }
}
