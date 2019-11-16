package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.ValueTypeDTO;
import com.project.bi.query.expression.condition.CollectionConditionExpression;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            str.append(getFeatureName());
            str.append(" NOT IN (");

            Stream<String> stringStream;
            if (getValueTypes() != null) {
                stringStream = getValueTypes()
                        .stream()
                        .map(ValueTypeDTO::interpret);
            } else {
                stringStream = getValues()
                        .stream()
                        .map(SQLUtil::preProcessValue);
            }

            String v = stringStream.collect(Collectors.joining(","));

            str.append(v)
                    .append(")");

        }

        return str.toString();
    }
}
