package com.expressionparser.main;


import com.expressionparser.main.service.ExpressionParseService;
import com.expressionparser.main.utils.Validate;

import static com.expressionparser.main.domain.InputExpression.getInputExpression;

public class ApplicationStarter {

    public static void main(String[] args) {

        System.out.println("Hello customer\n");
        if (args.length != 1) {
            System.out.println("Argument is either empty or more than one");
        }

        String input = args[0].trim();

        if (Validate.validateInputString(input)) {
            try {
                System.out.println(ExpressionParseService.getInstance().parse(getInputExpression(input)));
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        } else {
            System.out.println("The input expression is not valid");
        }
    }
}
