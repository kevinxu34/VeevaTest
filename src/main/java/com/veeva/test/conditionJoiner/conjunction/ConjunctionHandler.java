package com.veeva.test.conditionJoiner.conjunction;

import com.veeva.test.conditionJoiner.model.Condition;
import com.veeva.test.conditionJoiner.operator.OperatorFactory;
import com.veeva.test.conditionJoiner.operator.OperatorHandler;

import java.util.List;
import java.util.StringJoiner;

public abstract class ConjunctionHandler {
    protected abstract StringJoiner getStringJoiner();

    public String join(List<String> conditions, int level) {
        StringJoiner sj = getStringJoiner();
        conditions.stream().forEach(e -> sj.add(e));

        if(level > 0) {
            return "(" + sj.toString() + ")";
        } else {
            return sj.toString();
        }

    }
}
