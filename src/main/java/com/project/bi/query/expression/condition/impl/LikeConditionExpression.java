package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeConditionExpression extends SimpleConditionExpression {

    private String value;
    private boolean caseInsensitive;

    @Override
    public String interpret() {
        StringBuilder q = new StringBuilder();
        if (getFeatureName() != null) {
            q.append(toFeatureName())
                    .append(" LIKE ")
                    .append(toValue());
        }
        return q.toString();
    }

    private String toValue() {
        if (caseInsensitive) {
            return "UPPER('%" + value + "%')";
        }
        return "'%" + value + "%'";
    }

    private String toFeatureName() {
        if (caseInsensitive) {
            return "UPPER(" + featureName + ")";
        }
        return featureName;
    }
}
