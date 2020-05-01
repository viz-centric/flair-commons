package com.project.bi.query.dto;

import com.project.bi.query.expression.condition.impl.BetweenConditionExpression;
import com.project.bi.query.expression.condition.impl.CompareConditionExpression;
import com.project.bi.query.expression.operations.ArithmeticOperation;
import com.project.bi.query.expression.operations.OperationSign;
import com.project.bi.query.expression.operations.QueryOperation;
import com.project.bi.query.expression.operations.ScalarOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HavingDTOTest {

    @Test
    public void interpretWithoutOperation() {
        HavingDTO havingDTO = new HavingDTO();
        havingDTO.setComparatorType(HavingDTO.ComparatorType.GT);
        havingDTO.setFeature(new FieldDTO("order_qty", "count"));
        havingDTO.setOperation(new ScalarOperation("5"));

        Assert.assertEquals("count(order_qty) > 5", havingDTO.interpret());
    }

    @Test
    public void interpretWithOperation() {
        HavingDTO havingDTO = new HavingDTO();
        havingDTO.setComparatorType(HavingDTO.ComparatorType.GT);
        havingDTO.setFeature(new FieldDTO("order_qty", "count"));
        QueryDTO valueQuery = new QueryDTO();
        valueQuery.setQuerySource(new QuerySourceDTO("ecommerce", null));
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
        havingDTO.setOperation(
                new QueryOperation(valueQuery)
        );

        Assert.assertEquals("count(order_qty) > (SELECT max(transactions_summary) as transactions_summary FROM ecommerce WHERE order_date BETWEEN __FLAIR_INTERVAL_OPERATION(__FLAIR_NOW(), '-', '7000 days') AND __FLAIR_NOW())",
                havingDTO.interpret());
    }

    @Test
    public void interpretWithOperationAndQuerySource() {
        HavingDTO havingDTO = new HavingDTO();
        havingDTO.setComparatorType(HavingDTO.ComparatorType.GT);
        havingDTO.setFeature(new FieldDTO("order_qty", "count"));
        QueryDTO valueQuery = new QueryDTO();
        valueQuery.setQuerySource(new QuerySourceDTO("ecommerce", "A"));
        valueQuery.setFields(Arrays.asList(
                new FieldDTO("transactions_summary", "max", "transactions_summary")
        ));
        BetweenConditionExpression between = new BetweenConditionExpression();
        between.setFeatureName("order_date");
        between.setValueType(new IntervalValueTypeDTO("__FLAIR_NOW()", "7000 days", "-"));
        between.setSecondValueType(new ValueTypeDTO("__FLAIR_NOW()", null));
        CompareConditionExpression compare = new CompareConditionExpression(
                null, null,
                new CastValueTypeDTO("24", "number"),
                new FeaturePropertyDTO("order_count", "orders"),
                CompareConditionExpression.ComparatorType.GT
        );
        valueQuery.setConditionExpressions(Arrays.asList(
                new ConditionExpressionDTO(
                        ConditionExpressionDTO.SourceType.FILTER,
                        between
                ),
                new ConditionExpressionDTO(
                        ConditionExpressionDTO.SourceType.FILTER,
                        compare
                )
        ));
        havingDTO.setOperation(
                new ArithmeticOperation(
                        Arrays.asList(
                                new QueryOperation(valueQuery),
                                new ScalarOperation("0.9"),
                                new ScalarOperation("15")
                        ),
                        OperationSign.MULTIPLY
                )
        );

        Assert.assertEquals("count(order_qty) > ((SELECT max(transactions_summary) as transactions_summary FROM ecommerce A WHERE order_date BETWEEN __FLAIR_INTERVAL_OPERATION(__FLAIR_NOW(), '-', '7000 days') AND __FLAIR_NOW() AND orders.order_count > __FLAIR_CAST(number, 24)) * 0.9 * 15)",
                havingDTO.interpret());
    }
}
