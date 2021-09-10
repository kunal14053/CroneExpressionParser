package com.expressionparser.main.pojo;

import com.expressionparser.main.utils.Validate;


public class Command implements Operations{

    private String result;

    @Override
    public void parse(String entity) {
        result = entity;
    }

    @Override
    public String getResult(String command) throws Exception {
        if(Validate.validateCommand(command)){
            parse(command);
            return result;
        } else{
            throw new Exception("Command not valid");
        }

    }

    public static Command getInstance() {
        return new Command();
    }
}
