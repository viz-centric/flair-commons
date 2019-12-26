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
public class IntervalValueTypeDTO extends ValueDTO {
    private String value;
    private String interval;
    private String operator;

    @Override
    public String interpret() {
        return "__FLAIR_INTERVAL_OPERATION("
                + value
                + ", " + SQLUtil.preProcessValue(operator)
                + ", " + SQLUtil.preProcessValue(interval)
                + ")";
    }

}
