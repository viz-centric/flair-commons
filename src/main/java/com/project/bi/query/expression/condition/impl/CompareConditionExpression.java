package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.ValueTypeDTO;
import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompareConditionExpression extends SimpleConditionExpression {

    protected String value;
    protected ValueTypeDTO valueType;

    protected ComparatorType comparatorType;

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
        return interpret();
    }

    public enum ComparatorType {

        EQ("eq"),
        NEQ("neq"),
        GT("gt"),
        LT("lt"),
        GTE("gte"),
        LTE("lte");

        private final String value;

        ComparatorType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public String interpret() {
        StringBuilder q = new StringBuilder();
        if (getFeatureName() != null) {
            q.append(getFeatureName())
                    .append(" ")
                    .append(SQLUtil.getSQLComparatorTypeSymbol(comparatorType))
                    .append(" ")
                    .append(SQLUtil.preProcessValue(pickValue(valueType, value)));
        }
        return q.toString();
    }
}
