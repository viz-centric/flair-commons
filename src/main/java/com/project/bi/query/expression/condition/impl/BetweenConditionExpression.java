package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.ValueDTO;
import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BetweenConditionExpression extends SimpleConditionExpression {

    @Deprecated // use valueType instead
    protected String value;

    protected ValueDTO valueType;

    @Deprecated // use secondValueType instead
    protected String secondValue;

    protected ValueDTO secondValueType;

    @Override
    public String interpret() {
        String feature = getFeatureName();
        if (feature == null) {
            return "";
        }

        return feature
                + " BETWEEN "
                + pickValue(valueType, value)
                + " AND "
                + pickValue(secondValueType, secondValue);
    }
}
