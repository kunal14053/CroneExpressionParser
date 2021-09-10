package com.expressionparser.main.pojo;


public interface Operations {
    void parse(String entity) throws Exception;
    String getResult(String entity) throws Exception;
}
