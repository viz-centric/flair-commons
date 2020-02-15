package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PredefinedValueTypeDTO extends ValueDTO {
    public static final Set<Pattern> SUPPORTED_VALUE_TYPES = new HashSet<Pattern>() {{
        add(Pattern.compile("__FLAIR_[_A-Z]+\\(.*\\)"));
    }};

    private String value;

    @Override
    public String interpret() {
        boolean isAllowed = SUPPORTED_VALUE_TYPES.stream()
                .anyMatch(p -> p.matcher(value).matches());
        if (isAllowed) {
            return value;
        }
        throw new IllegalArgumentException("Cannot find predefined value type " + value);
    }
}
