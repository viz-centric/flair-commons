package com.project.bi.query.dto;

import com.project.bi.query.expression.condition.impl.BetweenConditionExpression;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HavingDTOTest {

    @Test
    public void interpretWithoutSubquery() {
        HavingDTO havingDTO = new HavingDTO();
        havingDTO.setComparatorType(HavingDTO.ComparatorType.GT);
        havingDTO.setFeature(new FieldDTO("order_qty", "count"));
        havingDTO.setValue("5");

        Assert.assertEquals("count(order_qty) > 5", havingDTO.interpret());
    }

    @Test
    public void interpretWithSubquery() {
        HavingDTO havingDTO = new HavingDTO();
        havingDTO.setComparatorType(HavingDTO.ComparatorType.GT);
        havingDTO.setFeature(new FieldDTO("order_qty", "count"));
        QueryDTO valueQuery = new QueryDTO();
        valueQuery.setSource("ecommerce");
        valueQuery.setFields(Arrays.asList(
                new FieldDTO("transactions_summary", "max", "transactions_summary")
        ));
        BetweenConditionExpression between = new BetweenConditionExpression();
        between.setFeatureName("order_date");
        between.setValueType(new IntervalValueTypeDTO("__FLAIR_NOW()", "7000 days", "-"));
        between.setSecondValueType(new ValueTypeDTO("__FLAIR_NOW()", null));
        valueQuery.setConditionExpressions(Arrays.asList(
                new ConditionExpressionDTO(
                        ConditionExpressionDTO.SourceType.FILTER,
                        between
                )
        ));
        havingDTO.setValueQuery(valueQuery);

        Assert.assertEquals("count(order_qty) > (SELECT max(transactions_summary) as transactions_summary FROM ecommerce WHERE order_date BETWEEN __FLAIR_INTERVAL_OPERATION(__FLAIR_NOW(), '-', '7000 days') AND __FLAIR_NOW())",
                havingDTO.interpret());
    }
}
