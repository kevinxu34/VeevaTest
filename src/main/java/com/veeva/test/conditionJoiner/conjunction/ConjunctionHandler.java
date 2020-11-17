package com.veeva.test.conditionJoiner.conjunction;

import com.veeva.test.conditionJoiner.model.Condition;
import com.veeva.test.conditionJoiner.operator.OperatorFactory;
import com.veeva.test.conditionJoiner.operator.OperatorHandler;

import java.util.List;
import java.util.StringJoiner;

public abstract class ConjunctionHandler {
    protected abstract StringJoiner getStringJoiner();

    public String join(List<Condition> conditions) {
        StringJoiner sj = getStringJoiner();
        for(Condition c : conditions) {
            OperatorHandler operatorHandler = OperatorFactory.getOperatorHandler(c.getOperator());
            if(operatorHandler != null) {
                sj.add(operatorHandler.join(c.getField(), c.getValues().get(0)));
            }
        }
        return sj.toString();
    }
}
