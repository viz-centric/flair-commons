package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastValueTypeDTOTest {

    @Test
    public void interpret() {
        CastValueTypeDTO dto = new CastValueTypeDTO();
        dto.setType("timestamp");
        dto.setValue("2019-10-11");
        assertEquals("__FLAIR_CAST(timestamp, '2019-10-11')", dto.interpret());
    }
}
