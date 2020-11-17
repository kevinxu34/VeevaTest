package com.veeva.test.conditionJoiner.operator;

import com.veeva.test.conditionJoiner.model.Operator;

import java.util.EnumMap;

import static com.veeva.test.conditionJoiner.model.Operator.*;

public class OperatorFactory {
    private static EnumMap<Operator, OperatorHandler> operatorHandlers = new EnumMap<>(Operator.class);

    static {
        operatorHandlers.put(like, new LikeHandler());
        operatorHandlers.put(notLike, new NotLikeHandler());
        operatorHandlers.put(greaterThanOrEqualTo, new GreaterThanOrEqualToHandler());
        operatorHandlers.put(equals, new EqualsHandler());
        operatorHandlers.put(notEquals, new NotEqualsHandler());
        operatorHandlers.put(lessThan, new LessThanHandler());
        operatorHandlers.put(greaterThan, new GreaterThanHandler());
        operatorHandlers.put(lessThanOrEqualTo, new LessThanOrEqualToHandler());
    }

    public static OperatorHandler getOperatorHandler(Operator operator) {
        return operatorHandlers.get(operator);
    }
}
