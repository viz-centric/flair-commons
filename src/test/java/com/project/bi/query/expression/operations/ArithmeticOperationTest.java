package com.project.bi.query.expression.operations;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArithmeticOperationTest {

    @Test
    public void interpretTwoParameters() {
        ArithmeticOperation operation = new ArithmeticOperation(
                Arrays.asList(
                        new ScalarOperation("test"),
                        new ScalarOperation("1.1")
                ),
                OperationSign.DIVIDE);
        assertEquals("('test' / 1.1)", operation.interpret());
    }

}
