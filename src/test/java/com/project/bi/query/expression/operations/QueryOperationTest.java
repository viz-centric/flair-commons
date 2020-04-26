package com.project.bi.query.expression.operations;

import com.project.bi.query.dto.FieldDTO;
import com.project.bi.query.dto.QueryDTO;
import com.project.bi.query.dto.QuerySourceDTO;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class QueryOperationTest {

    @Test
    public void interpret() {
        QueryDTO query = new QueryDTO();
        query.setQuerySource(new QuerySourceDTO("table_name"));
        query.setFields(asList(new FieldDTO("column_name")));
        assertEquals("(SELECT column_name FROM table_name)",
                new QueryOperation(query).interpret());
    }
}
