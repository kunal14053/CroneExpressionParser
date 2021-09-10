package com.expressionparser.main;


import com.expressionparser.main.service.ExpressionParser;
import com.expressionparser.main.utils.Validate;

public class ApplicationStarter {

    public static void main(String[] args) {

        System.out.println("Hello customer\n");
        if(args.length!=1){
            System.out.println("Argument is either empty or more than one");
        }

        String inputExpression = args[0].trim();

        if(Validate.validateInputString(inputExpression)){
            try {
                System.out.println(ExpressionParser.getExpressionParserInstance().returnOutputExpression(inputExpression));
            } catch (Exception e){
                System.out.println("Exception occurred: "+ e.getMessage());
            }

        }else {
            System.out.println("The input expression is not valid");
        }
    }

}
