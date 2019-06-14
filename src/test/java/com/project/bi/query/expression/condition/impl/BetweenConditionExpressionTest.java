package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.QueryFieldDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BetweenConditionExpressionTest {

    @Test
    public void interpret() {
        BetweenConditionExpression expression = new BetweenConditionExpression();
        expression.setSecondValue(QueryFieldDTO.of("second value"));
        expression.setValue(QueryFieldDTO.of("value"));
        expression.setFeatureName(QueryFieldDTO.of("feature_name"));

        String result = expression.interpret();

        assertEquals("feature_name BETWEEN 'value' AND 'second value'", result);
    }
}