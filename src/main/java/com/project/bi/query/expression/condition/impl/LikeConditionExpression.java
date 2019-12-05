package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeConditionExpression extends SimpleConditionExpression {

    protected String value;

    @Override
    public String interpret() {
        StringBuilder q = new StringBuilder();
        if (getFeatureName() != null) {
            q.append(getFeatureName())
                    .append(" LIKE ")
                    .append("'%")
                    .append(getValue())
                    .append("%'");
        }
        return q.toString();
    }
}
