package com.veeva.test.conditionJoiner.operator;

public class LikeHandler implements OperatorHandler{

    @Override
    public String join(String field, String value) {
        return field + " like " + value;
    }
}
