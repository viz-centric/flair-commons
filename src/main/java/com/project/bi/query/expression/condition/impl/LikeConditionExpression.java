package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.LikeFeatureNameDTO;
import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeConditionExpression extends SimpleConditionExpression {

    private String value;
    private LikeFeatureNameDTO featureType;
    private boolean caseInsensitive;

    @Override
    public String interpret() {
        return toFeatureName() +
                " LIKE " +
                toValue();
    }

    private String toValue() {
        if (caseInsensitive) {
            return "UPPER('%" + value + "%')";
        }
        return "'%" + value + "%'";
    }

    private String toFeatureName() {
        if (featureType != null) {
            if (caseInsensitive) {
                return "UPPER(" + featureType.interpret() + ")";
            } else {
                return featureType.interpret();
            }
        }
        return featureName;
    }
}
