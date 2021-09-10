package com.expressionparser.main.pojo;

import com.expressionparser.main.constants.AnyValue;
import com.expressionparser.main.constants.Other;
import com.expressionparser.main.constants.Range;
import com.expressionparser.main.utils.StringOperations;
import com.expressionparser.main.utils.Validate;

public class Month implements Operations{

    String result;

    @Override
    public void parse(String entity) throws Exception {

        if(entity.equals("*")){
            result = AnyValue.MONTH.getDuration();
        } else if(Validate.isValidNumber(entity, Range.MONTH)){
            result = entity;
        } else if(Validate.isValidRange(entity,Range.MONTH)){
            result = StringOperations.getRange(entity);
        } else if(Validate.isValidList(entity, Range.MONTH)){
            result = StringOperations.getList(entity);
        } else if(Validate.isValidStep(entity, Range.MONTH)) {
            result = StringOperations.getSteps(entity, Range.MONTH);
        } else if(Validate.isValidMonth(entity.toUpperCase())){
            result = String.valueOf(Other.MONTH.indexOf(entity.toUpperCase()));
        } else{
            throw new Exception("Invalid Month");
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

    public static Month getInstance() {
        return new Month();
    }

}
