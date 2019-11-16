package com.project.bi.query.dto;

import com.project.bi.query.SQLUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValueTypeDTO {
    private String value;
    private String type;

    public String interpret() {
        if (type == null) {
            return SQLUtil.preProcessValue(value);
        }
        return "__FLAIR(" + SQLUtil.preProcessValue(value) + ", " + type + ")";
    }
}
