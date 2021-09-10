package com.expressionparser.main.service;

import com.expressionparser.main.constants.Range;
import com.expressionparser.main.dto.InputExpression;
import com.expressionparser.main.pojo.*;

public class ParserFactory {


    public static ParserFactory getInstance() {
        return new ParserFactory();
    }

    public String getResult(Range range, InputExpression inputExpression) throws Exception {
        switch (range){
            case COMMAND:
                return Command.getInstance().getResult(inputExpression.getCommand());
            case HOUR:
                return Hour.getInstance().getResult(inputExpression.getHours());
            case MINUTE:
                return Minute.getInstance().getResult(inputExpression.getMinutes());
            case MONTH:
                return Month.getInstance().getResult(inputExpression.getMonth());
            case DAY_OF_MONTH:
                return DayOfMonth.getInstance().getResult(inputExpression.getDayOfMonth());
            case DAY_OF_WEEK:
                return DayOfWeek.getInstance().getResult(inputExpression.getDayOfWeek());
            default:
                throw new Exception("Invalid input entity");
        }
    }

}
