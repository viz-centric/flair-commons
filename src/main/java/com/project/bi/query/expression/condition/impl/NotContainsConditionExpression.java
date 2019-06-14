package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.expression.condition.CollectionConditionExpression;

import java.util.stream.Collectors;

import static com.project.bi.query.SQLUtil.sanitizeField;

public class NotContainsConditionExpression extends CollectionConditionExpression {


    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
        return interpret();
    }

    @Override
    public String interpret() {
        StringBuilder str = new StringBuilder();
        if (getFeatureName() != null) {
            str.append(sanitizeField(getFeatureName()));
            str.append(" NOT IN (");
            String values = getValues()
                    .stream()
                    .map(it -> sanitizeField(it))
                    .map(SQLUtil::preProcessValue)
                    .collect(Collectors.joining(","));

            if ("".equals(values)) {
                values = null;
            }

            str.append(values)
                    .append(")");

        }

        return str.toString();
    }
}
