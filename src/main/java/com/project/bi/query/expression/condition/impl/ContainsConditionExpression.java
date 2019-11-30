package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.ValueDTO;
import com.project.bi.query.expression.condition.CollectionConditionExpression;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainsConditionExpression extends CollectionConditionExpression {

    @Override
    public String interpret() {
        StringBuilder str = new StringBuilder();
        if (getFeatureName() != null) {

            str.append(getFeatureName());
            str.append(" IN (");

            Stream<String> stringStream;
            if (getValueTypes() != null) {
                stringStream = getValueTypes()
                        .stream()
                        .map(ValueDTO::interpret);
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
