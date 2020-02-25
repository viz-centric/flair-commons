package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.LikeFeatureNameDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LikeConditionExpressionTest {

    @Test
    public void interpret() {
        LikeConditionExpression expression = new LikeConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValue("value1");

        String result = expression.interpret();

        assertEquals("feature_name LIKE '%value1%'", result);
    }

    @Test
    public void interpretFeatureType() {
        LikeConditionExpression expression = new LikeConditionExpression();
        expression.setFeatureType(new LikeFeatureNameDTO("feature_name", "varchar"));
        expression.setValue("value1");

        String result = expression.interpret();

        assertEquals("__FLAIR_CAST(flair_string, feature_name) LIKE '%value1%'", result);
    }

    @Test
    public void interpretCaseInsensitive() {
        LikeConditionExpression expression = new LikeConditionExpression();
        expression.setFeatureName("feature_name");
        expression.setValue("value1");
        expression.setCaseInsensitive(true);

        String result = expression.interpret();

        assertEquals("feature_name LIKE UPPER('%value1%')", result);
    }

    @Test
    public void interpretCaseInsensitiveWithFeatureType() {
        LikeConditionExpression expression = new LikeConditionExpression();
        expression.setFeatureType(new LikeFeatureNameDTO("feature_name", "varchar"));
        expression.setValue("value1");
        expression.setCaseInsensitive(true);

        String result = expression.interpret();

        assertEquals("UPPER(__FLAIR_CAST(flair_string, feature_name)) LIKE UPPER('%value1%')", result);
    }
}
