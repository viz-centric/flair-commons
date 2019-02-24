package com.project.bi.query.expression.condition.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompareConditionExpressionTest {

    @Test
    public void interpret() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValue("value");
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name = 'value'", result);
    }
}