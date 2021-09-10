package com.expressionparser.main.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputExpression {

    private String command;
    private String minutes;
    private String hours;
    private String dayOfMonth;
    private String month;
    private String dayOfWeek;

    @Override
    public String toString(){
        return "minute  "+getMinutes()+"\n"
                +"hour  "+getHours()+"\n"
                +"day of month  "+getDayOfMonth()+"\n"
                +"month  "+getMonth()+"\n"
                +"day of week  "+getDayOfWeek()+"\n"
                +"command  "+getCommand()+"\n";
    }
}
