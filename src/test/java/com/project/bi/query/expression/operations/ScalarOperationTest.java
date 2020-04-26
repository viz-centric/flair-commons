package com.project.bi.query.expression.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarOperationTest {

    @Test
    public void interpretNumber() {
        assertEquals("99", new ScalarOperation("99").interpret());
    }

    @Test
    public void interpretString() {
        assertEquals("'test'", new ScalarOperation("test").interpret());
    }

}
