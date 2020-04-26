package com.project.bi.query.dto;

import com.project.bi.query.expression.condition.impl.AndConditionExpression;
import com.project.bi.query.expression.condition.impl.LikeConditionExpression;
import com.project.bi.query.expression.condition.impl.NotContainsConditionExpression;
import com.project.bi.query.expression.operations.ScalarOperation;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QueryDTOTest {

    @Test
    public void interpretTablename() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setQuerySource(new QuerySourceDTO("tablename", null));

        String result = queryDTO.interpret();
        assertEquals("SELECT * FROM tablename", result);
    }

    @Test
    public void interpretAll() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setQuerySource(new QuerySourceDTO("tablename", null));
        queryDTO.setDistinct(true);
        queryDTO.setLimit(10L);
        queryDTO.setOffset(53L);
        SortDTO sort = new SortDTO();
        sort.setFeature(new FieldDTO("book", "SUM"));
        sort.setDirection(SortDTO.Direction.DESC);
        queryDTO.setOrders(Arrays.asList(sort));
        queryDTO.setFields(Arrays.asList(new FieldDTO("book", "COUNT", "bookcount"),
                new FieldDTO("author", "SUM")));
        queryDTO.setGroupBy(Arrays.asList(new FieldDTO("mygroup1", "SUM"),
                new FieldDTO("mygroup2", null, null)));
        queryDTO.setHaving(Arrays.asList(
                HavingDTO.builder()
                        .comparatorType(HavingDTO.ComparatorType.GT)
                        .feature(new FieldDTO("mycolumn"))
                        .operation(new ScalarOperation("500"))
                        .build(),
                HavingDTO.builder()
                        .comparatorType(HavingDTO.ComparatorType.LT)
                        .feature(new FieldDTO("mycolumn2", "COUNT", null))
                        .operation(new ScalarOperation("test"))
                        .build()
        ));
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
        assertEquals("SELECT DISTINCT COUNT(book) as bookcount,SUM(author) FROM tablename WHERE date LIKE '%2019-01-%' AND date NOT IN ('2019-01-10','2019-01-11') GROUP BY SUM(mygroup1),mygroup2 HAVING mycolumn > 500 AND COUNT(mycolumn2) < 'test' ORDER BY SUM(book) DESC LIMIT 10 OFFSET 53", result);
    }

    @Test
    public void copy() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setQuerySource(new QuerySourceDTO("tablename", null));
        queryDTO.setDistinct(true);
        queryDTO.setLimit(10L);
        queryDTO.setOffset(53L);
        SortDTO sort = new SortDTO();
        sort.setFeature(new FieldDTO("book"));
        sort.setDirection(SortDTO.Direction.DESC);
        queryDTO.setOrders(Arrays.asList(sort));
        queryDTO.setFields(Arrays.asList(new FieldDTO("book"), new FieldDTO("author")));
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

        QueryDTO newQuery = new QueryDTO(queryDTO);
        assertEquals("SELECT DISTINCT book,author FROM tablename WHERE date LIKE '%2019-01-%' AND date NOT IN ('2019-01-10','2019-01-11') ORDER BY book DESC LIMIT 10 OFFSET 53", newQuery.interpret());
    }
}
