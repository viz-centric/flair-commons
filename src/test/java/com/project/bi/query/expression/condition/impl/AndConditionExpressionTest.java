package com.project.bi.query.expression.condition.impl;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AndConditionExpressionTest {

    @Test
    public void interpret() {
        AndConditionExpression expression = new AndConditionExpression();
        NotContainsConditionExpression firstExpression = new NotContainsConditionExpression();
        firstExpression.setFeatureName("book");
        firstExpression.setValues(Arrays.asList("value1", "value2"));
        expression.setFirstExpression(firstExpression);
        NotContainsConditionExpression secondExpression = new NotContainsConditionExpression();
        secondExpression.setFeatureName("author");
        secondExpression.setValues(Arrays.asList("value3", "value3"));
        expression.setSecondExpression(secondExpression);

        String result = expression.interpret();
        assertEquals("book NOT IN ('value1','value2') AND author NOT IN ('value3','value3')", result);
    }
}
