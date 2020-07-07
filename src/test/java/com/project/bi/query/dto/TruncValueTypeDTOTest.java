package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TruncValueTypeDTOTest {

    @Test
    public void interpret() {
        TruncValueTypeDTO dto = new TruncValueTypeDTO();
        dto.setValue("column_name");
        dto.setType("int");
        dto.setTime("seconds");
        assertEquals("__FLAIR_TRUNC(column_name, int, 'seconds')", dto.interpret());
    }
}