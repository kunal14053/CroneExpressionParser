package com.expressionparser.main;


import com.expressionparser.main.service.ExpressionParseService;


import java.util.Scanner;

import static com.expressionparser.main.constants.Constants.INVALID_EXPRESSION;


public class ApplicationStarter {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the Crone Expression: ");
        String str= sc.nextLine();

        if (str!=null && str.isEmpty()) {
            System.out.println("Expression is empty or null");
            System.exit(0);
        }

        String input = str.trim();
        String output = ExpressionParseService.getInstance().parse(input);
        System.out.println(output);

    }
}
