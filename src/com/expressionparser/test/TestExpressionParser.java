package com.expressionparser.test;


import com.expressionparser.main.service.ExpressionParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestExpressionParser {

    @Test
    public void testAssertEqual(){
        assertEquals(1,1);
    }

    @Test
    public void testNotEqual(){
        assertNotEquals(1,2);
    }

    @Test
    public void testSimpleExpression() throws Exception {
        System.out.println(ExpressionParser.getExpressionParserInstance().
                returnOutputExpression("*/15 0 1,15 * 1-5 /usr/bin/find"));
        System.out.println(ExpressionParser.getExpressionParserInstance().
                returnOutputExpression("* 0 1-5 * 1-5 /usr/bin/find"));
        System.out.println(ExpressionParser.getExpressionParserInstance().
                returnOutputExpression("* * * * * /usr/bin/find"));

    }
}
