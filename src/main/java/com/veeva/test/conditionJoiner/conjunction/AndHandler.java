package com.veeva.test.conditionJoiner.conjunction;

import java.util.StringJoiner;

public class AndHandler extends ConjunctionHandler {
    private static final StringJoiner sj = new StringJoiner(" AND ");

    @Override
    protected StringJoiner getStringJoiner() {
        return sj;
    }
}
