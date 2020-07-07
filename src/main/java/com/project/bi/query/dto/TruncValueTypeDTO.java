package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.preProcessValue;
import static com.project.bi.query.SQLUtil.sanitize;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TruncValueTypeDTO extends ValueDTO {
    private String value;
    private String type;
    private String time;

    @Override
    public String interpret() {
        return "__FLAIR_TRUNC(" + sanitize(value) + ", " + type + ", " + preProcessValue(time) + ")";
    }
}
