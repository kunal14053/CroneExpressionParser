package com.expressionparser.main;


import com.expressionparser.main.service.ExpressionParseService;
import com.expressionparser.main.utils.Validate;

import java.util.Scanner;

import static com.expressionparser.main.domain.InputExpression.getInputExpression;

public class ApplicationStarter {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the Crone Expression: ");
        String str= sc.nextLine();

        if (str.isEmpty()) {
            System.out.println("Expression is empty or null");
            System.exit(0);
        }

        String input = str.trim();

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
