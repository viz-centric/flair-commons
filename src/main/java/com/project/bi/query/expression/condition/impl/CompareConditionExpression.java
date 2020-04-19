package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.FeaturePropertyDTO;
import com.project.bi.query.dto.ValueDTO;
import com.project.bi.query.expression.condition.AbstractConditionExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompareConditionExpression extends AbstractConditionExpression {

    @Deprecated // use valueType instead
    private String value;

    @Deprecated // use featureProperty instead
    private String featureName;

    private ValueDTO valueType;

    private FeaturePropertyDTO featureProperty;

    private ComparatorType comparatorType;

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
        q.append(interpretFeature())
                .append(" ")
                .append(SQLUtil.getSQLComparatorTypeSymbol(comparatorType))
                .append(" ")
                .append(pickValue(valueType, value));
        return q.toString();
    }

    private String interpretFeature() {
        if (featureProperty != null) {
            return featureProperty.interpret();
        }
        return getFeatureName();
    }

    private String pickValue(ValueDTO valueType, String value) {
        if (valueType != null) {
            return valueType.interpret();
        }
        return SQLUtil.preProcessValue(value);
    }
}
