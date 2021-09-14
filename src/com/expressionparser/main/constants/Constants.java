package com.expressionparser.main.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static String WILDCARD = "*";
    public static String SPACE = "\\s+";
    public static int LENGTH_OF_EXPRESSION = 6;
    public static List<String> DAYS_OF_WEEK = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
    public static List<String> MONTH = Arrays.asList("JAN","FEB","MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP",
            "OCT", "NOV", "DEC");
    public static String INVALID_EXPRESSION = "The input expression is not valid";
}
