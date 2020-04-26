package com.project.bi.query.expression.operations;

import com.project.bi.query.dto.QueryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryOperation implements Operation {

    public static final String TYPE = "query";

    private QueryDTO value;

    @Override
    public String interpret() {
        return "(" + value.interpret() + ")";
    }

}
