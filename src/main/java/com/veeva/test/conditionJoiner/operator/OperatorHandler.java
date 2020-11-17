package com.veeva.test.conditionJoiner.operator;

import com.veeva.test.conditionJoiner.model.Condition;

public interface OperatorHandler {
    String join(String field, String value);
}
