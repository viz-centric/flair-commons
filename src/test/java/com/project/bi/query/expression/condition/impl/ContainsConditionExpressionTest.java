package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.QueryFieldDTO;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ContainsConditionExpressionTest {

    @Test
    public void interpret() {
        ContainsConditionExpression expression = new ContainsConditionExpression();
        expression.setFeatureName(QueryFieldDTO.of("feature_name"));
        expression.setValues(Arrays.asList(QueryFieldDTO.of("value1"), QueryFieldDTO.of("value2")));

        String result = expression.interpret();

        assertEquals("feature_name IN ('value1','value2')", result);
    }
}