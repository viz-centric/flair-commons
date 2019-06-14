package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.QueryFieldDTO;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AndConditionExpressionTest {

    @Test
    public void interpret() {
        AndConditionExpression expression = new AndConditionExpression();
        NotContainsConditionExpression firstExpression = new NotContainsConditionExpression();
        firstExpression.setFeatureName(QueryFieldDTO.of("book"));
        firstExpression.setValues(Arrays.asList(QueryFieldDTO.of("value1"), QueryFieldDTO.of("value2")));
        expression.setFirstExpression(firstExpression);
        NotContainsConditionExpression secondExpression = new NotContainsConditionExpression();
        secondExpression.setFeatureName(QueryFieldDTO.of("author"));
        secondExpression.setValues(Arrays.asList(QueryFieldDTO.of("value3"), QueryFieldDTO.of("value3")));
        expression.setSecondExpression(secondExpression);

        String result = expression.interpret();
        assertEquals("book NOT IN ('value1','value2') AND author NOT IN ('value3','value3')", result);
    }
}