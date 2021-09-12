package com.expressionparser.test;


import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.service.ExpressionParseService;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestExpressionParser {

    @Before
    public void init() {

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
    public void testSimpleExpression() throws Exception {
        System.out.println(ExpressionParseService.getInstance().parse(InputExpression.getInputExpression("*/15 0 1,15 * 1-5 /usr/bin/find")));
        System.out.println(ExpressionParseService.getInstance().parse(InputExpression.getInputExpression("* 0 1-5 * 1-5 /usr/bin/find")));
        System.out.println(ExpressionParseService.getInstance().parse(InputExpression.getInputExpression("* 0 1-5 * 1-5 /usr/bin/find")));
    }
}
