package com.project.bi.query.dto;

import com.project.bi.query.SQLUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValueTypeDTO extends ValueDTO {
    private String value;
    private String type;

    public String interpret() {
        return "__FLAIR_CAST(" + type + ", " + SQLUtil.preProcessValue(value) + ")";
    }
}
