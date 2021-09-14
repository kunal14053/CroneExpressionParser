package com.expressionparser.test;


import com.expressionparser.main.ApplicationStarter;
import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.service.ExpressionParseService;
import org.junit.Before;
import org.junit.Test;


import static com.expressionparser.main.constants.Constants.INVALID_EXPRESSION;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestExpressionParser {

    ExpressionParseService serviceInstance;

    @Before
    public void init() {
        serviceInstance = ExpressionParseService.getInstance();
    }

    @Test
    public void testAssertEqual() {
        assertEquals(1, 1);
    }

    @Test
    public void testNotEqual() {
        assertNotEquals(1, 2);
    }

    @Test
    public void testValidExpression() throws Exception {
        assertEquals(serviceInstance.parse("*/15 0 1,15 * 1-5 /usr/bin/find"),
                "minute  0 15 30 45 \n" +
                "hour  0\n" +
                "day of month  1 15\n" +
                "month  Every Month of Year\n" +
                "day of week  1 2 3 4 5\n" +
                "command  /usr/bin/find\n");

        assertEquals(serviceInstance.parse("* * * * * /usr/bin/find"),
                "minute  Every Minute\n" +
                "hour  Every Hour\n" +
                "day of month  Every Day Of Month\n" +
                "month  Every Month of Year\n" +
                "day of week  Every Day Of Week\n" +
                "command  /usr/bin/find\n");

        assertEquals(serviceInstance.parse("* 0 1-5 * 1-5 /usr/bin/find"),
                "minute  Every Minute\n" +
                "hour  0\n" +
                "day of month  1 2 3 4 5\n" +
                "month  Every Month of Year\n" +
                "day of week  1 2 3 4 5\n" +
                "command  /usr/bin/find\n");
    }

    @Test
    public void testInValidExpression_With_Invalid_Range() {
        //length greater than 6
        assertEquals(serviceInstance.parse("* 0 1-5 * 1-5 /usr/bin/find * * * "), INVALID_EXPRESSION);
        //Invalid Minute, Range of minute is from 0 to 59
        assertEquals(serviceInstance.parse("71 0 1-5 * 1-5 /usr/bin/find"), INVALID_EXPRESSION);
        //Invalid Hour, Range of hour is from 0 to 23
        assertEquals(serviceInstance.parse("1-10 27 1-5 * 1-5 /usr/bin/find"), INVALID_EXPRESSION);
        //Invalid Day of Month, Range of days of month is from 1 to 31
        assertEquals(serviceInstance.parse("1-10 * 35 * 1-5 /usr/bin/find"), INVALID_EXPRESSION);
        //Invalid Month, Range of month is from 1 to 12
        assertEquals(serviceInstance.parse("1-10 * 1,2,3,4 35 1-5 /usr/bin/find"), INVALID_EXPRESSION);
        //Invalid Day of week, Range of Day of week is from 0 to 6
        assertEquals(serviceInstance.parse("1-10 * 1,2,3,4 11 8 /usr/bin/find"), INVALID_EXPRESSION);
    }

    @Test
    public void testInValidExpression_With_Invalid_range_of_values() {
        //Invalid Day of Month, as it ranges from 1 to 31, but the list is from 1 to 35
        assertEquals(serviceInstance.parse("* 0 1-35 * 1-5 /usr/bin/find"), INVALID_EXPRESSION);
    }

    @Test
    public void testInValidExpression_With_Invalid_step_value() {
        //we can only have */range of that field in the step value, thus the minute here is invalid
        assertEquals(serviceInstance.parse("12/24 0 * * 1-5 /usr/bin/find"), INVALID_EXPRESSION);
    }

    @Test
    public void testInValidExpression_With_Invalid_list() {
        //Invalid Day of Week, because the list can't have 9 in it
        assertEquals(serviceInstance.parse("*/24 0 * * 1,2,3,4,5,9 /usr/bin/find"), INVALID_EXPRESSION);

        //Invalid expression because of invalid list
        assertEquals(serviceInstance.parse("*/24 0 * * 1,2,3,4,5, , /usr/bin/find"), INVALID_EXPRESSION);
    }

    @Test
    public void testInValidExpression_With_empty_command() {
        //Invalid Day of Month, as it ranges from 1 to 31, but the list is from 1 to 35
        assertEquals(serviceInstance.parse("* 0 * * 1-5  "), INVALID_EXPRESSION);
    }

}
