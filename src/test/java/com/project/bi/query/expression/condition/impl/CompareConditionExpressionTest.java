package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.ValueTypeDTO;
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

    @Test
    public void interpretWithValueType() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValueType(new ValueTypeDTO("value", "timestamp"));
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name = __FLAIR(timestamp, 'value')", result);
    }

    @Test
    public void interpretWithValueTypeNoType() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValueType(new ValueTypeDTO("value", null));
        expression.setValue("value");
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name = 'value'", result);
    }

    @Test
    public void interpretWithValueAndValueType() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValueType(new ValueTypeDTO("value", "timestamp"));
        expression.setValue("value");
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name = __FLAIR(timestamp, 'value')", result);
    }
}
