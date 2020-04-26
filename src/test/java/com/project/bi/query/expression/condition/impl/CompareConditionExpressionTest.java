package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.CastValueTypeDTO;
import com.project.bi.query.dto.FeaturePropertyDTO;
import com.project.bi.query.dto.FeatureValueTypeDTO;
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
        expression.setValueType(new CastValueTypeDTO("value", "timestamp"));
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name = __FLAIR_CAST(timestamp, 'value')", result);
    }

    @Test
    public void interpretWithValueAndValueType() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValueType(new CastValueTypeDTO("value", "timestamp"));
        expression.setValue("value");
        expression.setFeatureName("feature_name");

        String result = expression.interpret();

        assertEquals("feature_name = __FLAIR_CAST(timestamp, 'value')", result);
    }

    @Test
    public void interpretWithFeatureValueType() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValueType(new CastValueTypeDTO("value", "timestamp"));
        expression.setFeatureProperty(new FeaturePropertyDTO("feature_name", null));

        String result = expression.interpret();

        assertEquals("feature_name = __FLAIR_CAST(timestamp, 'value')", result);
    }

    @Test
    public void interpretWithFeatureValueTypeAndTable() {
        CompareConditionExpression expression = new CompareConditionExpression();
        expression.setComparatorType(CompareConditionExpression.ComparatorType.EQ);
        expression.setValueType(new FeatureValueTypeDTO("orders_count", "another_table"));
        expression.setFeatureProperty(new FeaturePropertyDTO("feature_name", "my_table"));

        String result = expression.interpret();

        assertEquals("my_table.feature_name = another_table.orders_count", result);
    }
}
