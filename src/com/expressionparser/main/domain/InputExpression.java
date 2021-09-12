package com.expressionparser.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.expressionparser.main.constants.Constants.SPACE;

@Getter
@Setter
@AllArgsConstructor
public class InputExpression {

    private String command;
    private String minutes;
    private String hours;
    private String dayOfMonth;
    private String month;
    private String dayOfWeek;

    public static InputExpression getInputExpression(String input){
        String[] components = input.split(SPACE);
        return new InputExpression(components[5], components[0], components[1],
                components[2],components[3], components[4]);
    }
}
