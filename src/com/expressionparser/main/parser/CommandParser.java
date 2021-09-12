package com.expressionparser.main.parser;

import com.expressionparser.main.domain.InputExpression;
import com.expressionparser.main.utils.Validate;

public class CommandParser implements Parser {

    private CommandParser(){}
    private static final CommandParser obj = new CommandParser();
    public static CommandParser getInstance() {
        return obj;
    }

    @Override
    public String parse(InputExpression expression) throws Exception {
        String entity = expression.getCommand();
        if (Validate.validateCommand(entity)) {
            return entity;
        } else {
            throw new Exception("Command not valid");
        }
    }
}
