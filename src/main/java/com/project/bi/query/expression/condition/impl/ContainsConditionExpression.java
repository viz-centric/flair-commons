package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.ValueDTO;
import com.project.bi.query.expression.condition.CollectionConditionExpression;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ContainsConditionExpression extends CollectionConditionExpression {

    @Override
    public String interpret() {
        StringBuilder str = new StringBuilder();
        if (getFeatureName() != null) {

            String expr = composeInExpr();
            if (expr.length() > 0) {
                str.append(getFeatureName())
                        .append(expr);
            }

            boolean isValueNull = composeIfNullExpr();

            if (isValueNull && expr.length() > 0) {
                str.append(" OR ");
            }

            if (isValueNull) {
                str.append(getFeatureName())
                        .append(" IS NULL");
            }
        }

        return str.toString();
    }

    protected boolean composeIfNullExpr() {
        boolean nullValue = false;
        if (getValueTypes() != null) {
            nullValue = getValueTypes()
                    .stream()
                    .anyMatch(p -> p.getValue() == null || p.getValue().equals("null"));
        }
        return nullValue;
    }

    protected String composeInExpr() {
        List<String> strings;
        if (getValueTypes() != null) {
            strings = getValueTypes()
                    .stream()
                    .filter(p -> p.getValue() != null && !p.getValue().equals("null"))
                    .map(ValueDTO::interpret)
                    .collect(toList());
        } else {
            strings = getValues()
                    .stream()
                    .map(SQLUtil::preProcessValue)
                    .collect(toList());
        }

        if (strings.size() == 0) {
            return "";
        }

        return " IN (" +
                String.join(",", strings) +
                ")";
    }
}
