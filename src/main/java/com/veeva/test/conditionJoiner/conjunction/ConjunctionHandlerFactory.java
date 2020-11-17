package com.veeva.test.conditionJoiner.conjunction;

import com.veeva.test.conditionJoiner.model.Conjunction;

import java.util.EnumMap;

import static com.veeva.test.conditionJoiner.model.Conjunction.*;

public class ConjunctionHandlerFactory {
    private static EnumMap<Conjunction, ConjunctionHandler> conjunctionHandlers = new EnumMap<>(Conjunction.class);
    static {
        conjunctionHandlers.put(and, new AndHandler());
        conjunctionHandlers.put(or, new OrHandler());
    }

    public static ConjunctionHandler getConjunctionHandler(Conjunction conjunction) {
        return conjunctionHandlers.get(conjunction);
    }
}
