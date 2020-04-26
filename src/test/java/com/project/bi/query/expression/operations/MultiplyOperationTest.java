package com.project.bi.query.expression.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyOperationTest {

    @Test
    public void interpretOneParameter() {
        assertEquals("'test'", new MultiplyOperation(new ScalarOperation("test")).interpret());
    }

    @Test
    public void interpretTwoParameter() {
        assertEquals("('test' / 1.1)", new MultiplyOperation(
                new ScalarOperation("test"),
                OperationSign.DIVIDE,
                new ScalarOperation("1.1")).interpret());
    }
}
