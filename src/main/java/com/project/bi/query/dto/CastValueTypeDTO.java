package com.project.bi.query.dto;

import com.project.bi.query.SQLUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastValueTypeDTO extends ValueDTO {
    private String value;
    private String type;

    @Override
    public String interpret() {
        return "__FLAIR_CAST(" + type + ", " + SQLUtil.preProcessValue(SQLUtil.sanitize(value)) + ")";
    }
}
