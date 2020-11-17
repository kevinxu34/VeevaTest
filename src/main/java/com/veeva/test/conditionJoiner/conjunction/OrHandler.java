package com.veeva.test.conditionJoiner.conjunction;

import java.util.StringJoiner;

public class OrHandler extends ConjunctionHandler{

    @Override
    protected StringJoiner getStringJoiner() {
        return new StringJoiner(" OR ");
    }
}
