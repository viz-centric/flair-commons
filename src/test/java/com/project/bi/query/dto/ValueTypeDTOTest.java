package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValueTypeDTOTest {

    @Test
    public void interpretFlairNow() {
        ValueTypeDTO dto = new ValueTypeDTO("__FLAIR_NOW()", null);
        assertEquals("__FLAIR_NOW()", dto.interpret());
    }

    @Test
    public void interpretFlairNowWithParams() {
        ValueTypeDTO dto = new ValueTypeDTO("__FLAIR_NOW(timestamp)", null);
        assertEquals("__FLAIR_NOW(timestamp)", dto.interpret());
    }

    @Test
    public void interpretFlairNowWithMultipleParams() {
        ValueTypeDTO dto = new ValueTypeDTO("__FLAIR_NOW(timestamp, 'test 123/_\\')", null);
        assertEquals("__FLAIR_NOW(timestamp, 'test 123/_\\')", dto.interpret());
    }

    @Test
    public void interpretThrowsErrorForUnknownValue() {
        ValueTypeDTO dto = new ValueTypeDTO("some value()", "varchar");
        assertEquals("__FLAIR_CAST(varchar, 'some value()')", dto.interpret());
    }
}
