package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.sanitize;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureValueTypeDTO extends ValueDTO {
    private String table;

    public FeatureValueTypeDTO(String value, String table) {
        super(value);
        this.table = table;
    }

    @Override
    public String interpret() {
        if (getValue() == null) {
            return null;
        }
        if (table != null) {
            return sanitize(table) + "." + sanitize(getValue());
        }
        return sanitize(getValue());
    }
}
