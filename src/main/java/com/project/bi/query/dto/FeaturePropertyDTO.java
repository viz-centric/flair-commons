package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.sanitize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeaturePropertyDTO implements Interpretable {
    private String property;
    private String table;

    @Override
    public String interpret() {
        if (table == null) {
            return sanitize(property);
        }
        return sanitize(table) + "." + sanitize(property);
    }
}
