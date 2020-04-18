package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.CastValueTypeDTO;
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
                new CastValueTypeDTO("value1", "timestamp"),
                new CastValueTypeDTO("value2", "date")
        ));

        String result = expression.interpret();

        assertEquals("feature_name IN (__FLAIR_CAST(timestamp, 'value1'),__FLAIR_CAST(date, 'value2'))", result);
    }

    @Test
    public void interpretWithValueTypeAndNullValue() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValueTypes(Arrays.asList(
                new CastValueTypeDTO(null, "timestamp"),
                new CastValueTypeDTO("value2", "date")
        ));

        String result = expression.interpret();

        assertEquals("feature_name IN (__FLAIR_CAST(date, 'value2')) OR feature_name IS NULL", result);
    }

    @Test
    public void interpretWithValueTypeAndNullValueOnly() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValueTypes(Arrays.asList(
                new CastValueTypeDTO(null, "timestamp")
        ));

        String result = expression.interpret();

        assertEquals("feature_name IS NULL", result);
    }

    @Test
    public void interpretWithValueAndValueType() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValues(Arrays.asList("value3", "value4"));
        expression.setValueTypes(Arrays.asList(
                new CastValueTypeDTO("value1", "timestamp"),
                new CastValueTypeDTO("value2", "date")
        ));

        String result = expression.interpret();

        assertEquals("feature_name IN (__FLAIR_CAST(timestamp, 'value1'),__FLAIR_CAST(date, 'value2'))", result);
    }
}
