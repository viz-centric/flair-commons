package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RawQuerySourceDTOTest {

    @Test
    public void interpret() {
        RawQuerySourceDTO dto = new RawQuerySourceDTO("select * from db");
        assertEquals("__FLAIR_RAW([[select * from db]])", dto.interpret());
    }
}