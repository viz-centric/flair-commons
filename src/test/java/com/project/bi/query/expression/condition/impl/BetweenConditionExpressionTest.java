package com.project.bi.query.expression.condition.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BetweenConditionExpressionTest {

    @Test
    public void interpret() {
        BetweenConditionExpression expression = new BetweenConditionExpression();
        expression.setSecondValue("second value");
        expression.setValue("value");
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name BETWEEN 'value' AND 'second value'", result);
    }
}