package com.project.bi.query.expression.condition.impl;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ContainsConditionExpressionTest {

    @Test
    public void interpret() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValues(Arrays.asList("value1", "value2"));

        String result = expression.interpret();

        assertEquals("feature_name IN ('value1','value2')", result);
    }
}