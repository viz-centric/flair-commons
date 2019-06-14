package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.QueryFieldDTO;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class OrConditionExpressionTest {

    @Test
    public void interpret() {
        OrConditionExpression expression = new OrConditionExpression();
        NotContainsConditionExpression firstExpression = new NotContainsConditionExpression();
        firstExpression.setValues(Arrays.asList(QueryFieldDTO.of("value1")));
        firstExpression.setFeatureName(QueryFieldDTO.of("feature_name1"));
        expression.setFirstExpression(firstExpression);
        NotContainsConditionExpression secondExpression = new NotContainsConditionExpression();
        secondExpression.setValues(Arrays.asList(QueryFieldDTO.of("value2")));
        secondExpression.setFeatureName(QueryFieldDTO.of("feature_nam2"));
        expression.setSecondExpression(secondExpression);

        String result = expression.interpret();

        assertEquals("feature_name1 NOT IN ('value1') OR feature_nam2 NOT IN ('value2')", result);
    }
}