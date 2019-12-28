package com.project.bi.query.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldDTOTest {

    @Test
    public void interpretAll() {
        FieldDTO fieldDTO = new FieldDTO("orders", "SUM", "ordersum");
        assertEquals("SUM(orders) as ordersum", fieldDTO.interpret());
    }

    @Test
    public void interpretNameAndAggregation() {
        FieldDTO fieldDTO = new FieldDTO("orders", "SUM");
        assertEquals("SUM(orders)", fieldDTO.interpret());
    }

    @Test
    public void interpretAggregationOnly() {
        FieldDTO fieldDTO = new FieldDTO(null, "SUM");
        assertEquals("SUM()", fieldDTO.interpret());
    }

    @Test
    public void interpretAggregationAndAlias() {
        FieldDTO fieldDTO = new FieldDTO(null, "SUM", "ordersum");
        assertEquals("SUM() as ordersum", fieldDTO.interpret());
    }

    @Test
    public void interpretName() {
        FieldDTO fieldDTO = new FieldDTO("orders");
        assertEquals("orders", fieldDTO.interpret());
    }
}
