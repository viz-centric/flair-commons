package com.project.bi.query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SQLUtilTest {

    @Test
    public void sanitizeEscapesQuotes() {
        assertEquals("select * from ''test''", SQLUtil.sanitizeString("select * from 'test'"));
    }

    @Test
    public void sanitizeReturnsNull() {
        assertNull(SQLUtil.sanitizeField(null));
    }

    @Test
    public void sanitizeReturnsEmptyString() {
        assertEquals("", SQLUtil.sanitizeString(""));
    }
}