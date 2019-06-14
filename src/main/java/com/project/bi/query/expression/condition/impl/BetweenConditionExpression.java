package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.QueryFieldDTO;
import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.project.bi.query.SQLUtil.sanitizeField;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BetweenConditionExpression extends SimpleConditionExpression {

    protected QueryFieldDTO value;

    protected QueryFieldDTO secondValue;


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

        return sanitizeField(getFeatureName())
                + " BETWEEN "
                + SQLUtil.preProcessValue(sanitizeField(getValue()))
                + " AND "
                + SQLUtil.preProcessValue(sanitizeField(getSecondValue()));
    }
}
