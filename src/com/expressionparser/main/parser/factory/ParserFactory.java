package com.expressionparser.main.parser.factory;

import com.expressionparser.main.constants.enums.Range;
import com.expressionparser.main.parser.CommandParser;
import com.expressionparser.main.parser.DayOfMonthParser;
import com.expressionparser.main.parser.DayOfWeek;
import com.expressionparser.main.parser.Hour;
import com.expressionparser.main.parser.Minute;
import com.expressionparser.main.parser.Month;
import com.expressionparser.main.parser.Parser;

public class ParserFactory {
    private static final ParserFactory obj = new ParserFactory();

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return obj;
    }

    public Parser getParser(Range range) throws Exception {
        switch (range){
            case COMMAND:
                return CommandParser.getInstance();
            case HOUR:
                return Hour.getInstance();
            case MINUTE:
                return Minute.getInstance();
            case MONTH:
                return Month.getInstance();
            case DAY_OF_MONTH:
                return DayOfMonthParser.getInstance();
            case DAY_OF_WEEK:
                return DayOfWeek.getInstance();
            default:
                throw new Exception("Invalid input entity");
        }
    }

}
