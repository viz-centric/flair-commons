package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PredefinedValueTypeDTO extends ValueDTO {
    public static final Set<String> SUPPORTED_VALUE_TYPES = new HashSet<String>() {{
        add("__FLAIR_NOW()");
    }};

    private String value;

    @Override
    public String interpret() {
        if (SUPPORTED_VALUE_TYPES.contains(value)) {
            return value;
        }
        throw new IllegalArgumentException("Cannot find predefined value type " + value);
    }
}
