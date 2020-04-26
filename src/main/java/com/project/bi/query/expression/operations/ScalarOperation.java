package com.project.bi.query.expression.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.preProcessValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScalarOperation implements Operation {

    public static final String TYPE = "scalar";

    private String value;

    @Override
    public String interpret() {
        return preProcessValue(value);
    }

}
