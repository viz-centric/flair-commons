package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.ValueTypeDTO;
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

    @Test
    public void interpretWithValueType() {
        BetweenConditionExpression expression = new BetweenConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValueType(new ValueTypeDTO("value", "timestamp"));
        expression.setSecondValueType(new ValueTypeDTO("value2", "date"));

        String result = expression.interpret();

        assertEquals("feature_name BETWEEN __FLAIR('value', timestamp) AND __FLAIR('value2', date)", result);
    }

    @Test
    public void interpretWithValueTypeNoType() {
        BetweenConditionExpression expression = new BetweenConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValueType(new ValueTypeDTO("value", null));
        expression.setSecondValueType(new ValueTypeDTO("value2", null));

        String result = expression.interpret();

        assertEquals("feature_name BETWEEN 'value' AND 'value2'", result);
    }

    @Test
    public void interpretWithValueAndValueType() {
        BetweenConditionExpression expression = new BetweenConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setSecondValue("second value");
        expression.setValue("value");
        expression.setValueType(new ValueTypeDTO("value", "timestamp"));
        expression.setSecondValueType(new ValueTypeDTO("value2", "date"));

        String result = expression.interpret();

        assertEquals("feature_name BETWEEN __FLAIR('value', timestamp) AND __FLAIR('value2', date)", result);
    }
}
