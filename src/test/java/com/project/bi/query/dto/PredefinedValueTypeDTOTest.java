package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PredefinedValueTypeDTOTest {

    @Test
    public void interpret() {
        PredefinedValueTypeDTO dto = new PredefinedValueTypeDTO("__FLAIR_NOW()");
        assertEquals("__FLAIR_NOW()", dto.interpret());
    }

    @Test(expected = IllegalArgumentException.class)
    public void interpretThrowsErrorForUnknownValue() {
        PredefinedValueTypeDTO dto = new PredefinedValueTypeDTO("some value()");
        dto.interpret();
    }
}
