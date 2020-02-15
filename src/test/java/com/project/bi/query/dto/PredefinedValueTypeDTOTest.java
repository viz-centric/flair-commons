package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PredefinedValueTypeDTOTest {

    @Test
    public void interpretFlairNow() {
        PredefinedValueTypeDTO dto = new PredefinedValueTypeDTO("__FLAIR_NOW()");
        assertEquals("__FLAIR_NOW()", dto.interpret());
    }

    @Test
    public void interpretFlairNowWithParams() {
        PredefinedValueTypeDTO dto = new PredefinedValueTypeDTO("__FLAIR_NOW(timestamp)");
        assertEquals("__FLAIR_NOW(timestamp)", dto.interpret());
    }

    @Test
    public void interpretFlairNowWithMultipleParams() {
        PredefinedValueTypeDTO dto = new PredefinedValueTypeDTO("__FLAIR_NOW(timestamp, 'test 123/_\\')");
        assertEquals("__FLAIR_NOW(timestamp, 'test 123/_\\')", dto.interpret());
    }

    @Test(expected = IllegalArgumentException.class)
    public void interpretThrowsErrorForUnknownValue() {
        PredefinedValueTypeDTO dto = new PredefinedValueTypeDTO("some value()");
        dto.interpret();
    }
}
