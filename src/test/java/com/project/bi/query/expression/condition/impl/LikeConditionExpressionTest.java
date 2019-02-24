package com.project.bi.query.expression.condition.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LikeConditionExpressionTest {

    @Test
    public void interpret() {
        LikeConditionExpression expression = new LikeConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValue("value1");

        String result = expression.interpret();

        assertEquals("feature_name LIKE '%value1%'", result);
    }
}