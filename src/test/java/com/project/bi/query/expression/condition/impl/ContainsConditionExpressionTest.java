package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.ValueTypeDTO;
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

    @Test
    public void interpretWithValueType() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValueTypes(Arrays.asList(
                new ValueTypeDTO("value1", "timestamp"),
                new ValueTypeDTO("value2", "date")
        ));

        String result = expression.interpret();

        assertEquals("feature_name IN (__FLAIR('value1', timestamp),__FLAIR('value2', date))", result);
    }

    @Test
    public void interpretWithValueTypeNoType() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValues(Arrays.asList("value3", "value4"));
        expression.setValueTypes(Arrays.asList(
                new ValueTypeDTO("value1", null),
                new ValueTypeDTO("value2", null)
        ));

        String result = expression.interpret();

        assertEquals("feature_name IN ('value1','value2')", result);
    }

    @Test
    public void interpretWithValueAndValueType() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValues(Arrays.asList("value3", "value4"));
        expression.setValueTypes(Arrays.asList(
                new ValueTypeDTO("value1", "timestamp"),
                new ValueTypeDTO("value2", "date")
        ));

        String result = expression.interpret();

        assertEquals("feature_name IN (__FLAIR('value1', timestamp),__FLAIR('value2', date))", result);
    }
}
