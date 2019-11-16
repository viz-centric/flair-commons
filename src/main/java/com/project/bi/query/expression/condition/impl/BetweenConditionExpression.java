package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.ValueTypeDTO;
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

    protected String value;

    protected ValueTypeDTO valueType;

    protected String secondValue;

    protected ValueTypeDTO secondValueType;


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
        if (getFeatureName() == null) {
            return "";
        }

        return getFeatureName()
                + " BETWEEN "
                + SQLUtil.preProcessValue(pickValue(valueType, value))
                + " AND "
                + SQLUtil.preProcessValue(pickValue(secondValueType, secondValue));
    }
}
