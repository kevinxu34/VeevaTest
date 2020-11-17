package com.veeva.test.conditionJoiner.model;

import java.util.List;

public class Condition {
    private String field;
    private Operator operator;
    private List<String> values;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "field='" + field + '\'' +
                ", operator=" + operator +
                ", values=" + values +
                '}';
    }
}
