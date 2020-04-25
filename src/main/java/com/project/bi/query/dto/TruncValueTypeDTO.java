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
public class TruncValueTypeDTO extends ValueDTO {
    private String value;
    private String type;

    @Override
    public String interpret() {
        return "__FLAIR_TRUNC(" + type + ", " + sanitize(value) + ")";
    }
}
