package com.veeva.test.conditionJoiner.operator;

public class NotLikeHandler implements OperatorHandler{

    @Override
    public String join(String field, String value) {
        return "(NOT " + field + " like " + value + ")";
    }
}
