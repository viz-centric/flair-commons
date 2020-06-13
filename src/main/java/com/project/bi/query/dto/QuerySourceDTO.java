package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.sanitize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuerySourceDTO implements QuerySource {
    private String source;
    private String alias;

    public QuerySourceDTO(String source) {
        this.source = source;
    }

    @Override
    public String interpret() {
        return sanitize(source) + (alias == null ? "" : " " + sanitize(alias));
    }
}
