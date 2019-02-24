package com.project.bi.query.dto;

import com.project.bi.query.expression.condition.impl.AndConditionExpression;
import com.project.bi.query.expression.condition.impl.LikeConditionExpression;
import com.project.bi.query.expression.condition.impl.NotContainsConditionExpression;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QueryDTOTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void interpretTablename() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setSource("tablename");

        String result = queryDTO.interpret();
        assertEquals("SELECT * FROM tablename", result);
    }

    @Test
    public void interpretAll() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setSource("tablename");
        queryDTO.setDistinct(true);
        queryDTO.setLimit(10L);
        SortDTO sort = new SortDTO();
        sort.setFeatureName("book");
        sort.setDirection(SortDTO.Direction.DESC);
        queryDTO.setOrders(Arrays.asList(sort));
        queryDTO.setFields(Arrays.asList("book", "author"));
        ConditionExpressionDTO conditionExpressionDTO = new ConditionExpressionDTO();
        conditionExpressionDTO.setSourceType(ConditionExpressionDTO.SourceType.FILTER);
        AndConditionExpression conditionExpression = new AndConditionExpression();
        LikeConditionExpression firstExpression = new LikeConditionExpression();
        firstExpression.setValue("2019-01-");
        firstExpression.setFeatureName("date");
        conditionExpression.setFirstExpression(firstExpression);
        NotContainsConditionExpression secondExpression = new NotContainsConditionExpression();
        secondExpression.setFeatureName("date");
        secondExpression.setValues(Arrays.asList("2019-01-10", "2019-01-11"));
        conditionExpression.setSecondExpression(secondExpression);
        conditionExpressionDTO.setConditionExpression(conditionExpression);
        queryDTO.setConditionExpressions(Arrays.asList(conditionExpressionDTO));

        String result = queryDTO.interpret();
        assertEquals("SELECT DISTINCT book,author FROM tablename WHERE date LIKE '%2019-01-%' AND date NOT IN ('2019-01-10','2019-01-11') ORDER BY book DESC LIMIT 10", result);
    }
}