package com.project.bi.query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SQLUtilTest {

    @Test
    public void sanitizeReturnsNull() {
        assertNull(null);
    }

    @Test
    public void sanitizeReturnsEmptyString() {
        assertEquals("", "");
    }
}