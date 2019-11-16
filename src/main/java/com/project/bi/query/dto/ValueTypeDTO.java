package com.project.bi.query.dto;

import com.project.bi.query.SQLUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
