package com.project.bi.query.expression.condition.impl;

public class NotContainsConditionExpression extends ContainsConditionExpression {

    @Override
    public String interpret() {
        StringBuilder str = new StringBuilder();
        String feature = getFeatureName();
        if (feature != null) {

            String expr = composeInExpr();
            if (expr.length() > 0) {
                str.append(feature)
                        .append(" NOT")
                        .append(expr);
            }

            boolean isValueNull = composeIfNullExpr();

            if (isValueNull && expr.length() > 0) {
                str.append(" AND ");
            }

            if (isValueNull) {
                str.append(feature)
                        .append(" IS NOT NULL");
            }
        }

        return str.toString();
    }
}
