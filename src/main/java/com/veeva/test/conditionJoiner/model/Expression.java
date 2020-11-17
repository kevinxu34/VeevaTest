package com.veeva.test.conditionJoiner.model;

import java.util.List;

public class Expression {
    private List<Condition> conditions;
    private Conjunction conjunction;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Conjunction getConjunction() {
        return conjunction;
    }

    public void setConjunction(Conjunction conjunction) {
        this.conjunction = conjunction;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "conditions=" + conditions +
                ", conjunction=" + conjunction +
                '}';
    }
}
