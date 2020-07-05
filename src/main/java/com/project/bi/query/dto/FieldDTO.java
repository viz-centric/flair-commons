package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDTO implements Interpretable {

    private String name;
    private String aggregation;
    private String alias;

    public FieldDTO(String name) {
        this.name = name;
    }

    public FieldDTO(String name, String aggregation) {
        this.name = name;
        this.aggregation = aggregation;
    }

    @Override
    public String interpret() {
        StringBuilder sb = new StringBuilder();
        if (aggregation != null) {
            sb.append(aggregation)
                    .append("(");
        } else if (alias != null) {
            sb.append("(");
        }
        if (name != null) {
            sb.append(name);
        }
        if (aggregation != null) {
            sb.append(")");
        } else if (alias != null) {
            sb.append(")");
        }
        if (alias != null) {
            sb.append(" as ")
                    .append(alias);
        }
        return sb.toString();
    }
}
