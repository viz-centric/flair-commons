package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.preProcessValue;
import static com.project.bi.query.SQLUtil.sanitize;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryExpDTO implements Interpretable {
    private QueryDTO query;
    private String sign;
    private String factor;

    @Override
    public String interpret() {
        StringBuilder sb = new StringBuilder();
        if (sign != null) {
            sb.append("(");
        }
        sb.append(query.interpret());
        if (sign != null) {
            sb.append(")")
                    .append(" ")
                    .append(sanitize(sign))
                    .append(" ")
                    .append(preProcessValue(factor));
        }
        return sb.toString();
    }

}
