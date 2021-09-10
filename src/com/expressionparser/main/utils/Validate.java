package com.expressionparser.main.utils;

import com.expressionparser.main.constants.Other;
import com.expressionparser.main.constants.Range;


public class Validate {

    public static boolean validateInputString (String expression){
        if(!expression.isEmpty()) {
            String[] components = expression.split("\\s+");
            return components.length == Other.LENGTH_OF_EXPRESSION;
        }
        return false;
    }

    public static boolean validateCommand(String command){
        return command.isEmpty()==false;
    }


    public static boolean isValidNumber(String input, Range range) {
        try {
            int val = Integer.parseInt(input);
            if(val<= range.getEnd() && val>=range.getStart()){
                return true;
            } else{
                throw new Exception("Invalid input");
            }
        } catch(Exception e){
            return false;
        }
    }

    public static boolean isValidRange(String entity, Range range) {
        String[] components = entity.split("-");

        return components.length==2 && isValidNumber(components[0], range) && isValidNumber(components[1], range);

    }

    public static boolean isValidList(String entity, Range range) {
        String[] components = entity.split(",");
        boolean result=true;
        for(String x : components)
            result = result && isValidNumber(x, range);

        return result;
    }

    public static boolean isValidStep(String entity, Range range) {
        String[] components = entity.split("/");
        return components.length==2 && components[0].equals("*") && isValidNumber(components[1], range);
    }


    public static boolean isValidMonth(String month) {
        return Other.MONTH.contains(month);
    }

    public static boolean isValidDayOfWeek(String weekDay) {
        return Other.DAYS_OF_WEEK.contains(weekDay);
    }
}
