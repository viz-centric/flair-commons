package com.project.bi.query.dto;

import com.project.bi.query.SQLUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CastValueTypeDTO extends ValueTypeDTO {

    public CastValueTypeDTO(String value, String type) {
        super(value, type);
    }

    @Override
    public String interpret() {
        return "__FLAIR_CAST(" + getType() + ", " + SQLUtil.preProcessValue(SQLUtil.sanitize(getValue())) + ")";
    }
}
