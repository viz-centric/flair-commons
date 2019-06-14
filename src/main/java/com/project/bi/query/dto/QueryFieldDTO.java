package com.project.bi.query.dto;

import lombok.Data;

@Data
public class QueryFieldDTO {

    private String name;
    private QueryFieldTypeDTO type;

    public static QueryFieldDTO of(String name) {
        QueryFieldDTO dto = new QueryFieldDTO();
        dto.setName(name);
        return dto;
    }

    public static QueryFieldDTO of(String name, QueryFieldTypeDTO type) {
        QueryFieldDTO dto = new QueryFieldDTO();
        dto.setName(name);
        dto.setType(type);
        return dto;
    }
}
