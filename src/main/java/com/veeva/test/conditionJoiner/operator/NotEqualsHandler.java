package com.veeva.test.conditionJoiner.operator;

public class NotEqualsHandler implements OperatorHandler{
    @Override
    public String join(String field, String value) {
        return field + " != " + value;
    }
}
