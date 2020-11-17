package com.veeva.test.conditionJoiner.conjunction;

import java.util.StringJoiner;

public class OrHandler extends ConjunctionHandler{
    private static final StringJoiner sj = new StringJoiner(" OR ");

    @Override
    protected StringJoiner getStringJoiner() {
        return sj;
    }
}
