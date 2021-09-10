package com.expressionparser.main.utils;


import com.expressionparser.main.constants.Range;
import com.expressionparser.main.dto.InputExpression;

public class StringOperations {

    public static InputExpression getExpressionObject(String input){
        String[] components = input.split("\\s+");
        return new InputExpression(components[5], components[0], components[1],
                components[2],components[3], components[4]);
    }

    public static String getRange(String input){
        String[] components = input.split("-");
        int startVal = Integer.parseInt(components[0]);
        int endVal = Integer.parseInt(components[1]);
        String result="";
        for(int i=startVal;i<=endVal;i++)
            result += i+" ";

        return result.trim();
    }

    public static String getList(String input){
        String[] components = input.split(",");
        String result="";
        for(String x : components)
            result += x+" ";

        return result.trim();
    }

    public static String getSteps(String input, Range range){
        String[] components = input.split("/");
        int val = Integer.parseInt(components[1]);
        String result="";
        for(int i=range.getStart();i<= range.getEnd();i=i+val)
            result += i+" ";
        return result;
    }


}
