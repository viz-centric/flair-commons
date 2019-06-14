package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.QueryFieldDTO;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NotContainsConditionExpressionTest {

    @Test
    public void interpret() {
        NotContainsConditionExpression expression = new NotContainsConditionExpression();
        expression.setFeatureName(QueryFieldDTO.of("feature_name"));
        expression.setValues(Arrays.asList(QueryFieldDTO.of("value1"), QueryFieldDTO.of("value2")));

        String result = expression.interpret();

        assertEquals("feature_name NOT IN ('value1','value2')", result);
    }
}