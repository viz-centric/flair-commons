package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project.bi.query.SQLUtil.sanitize;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawQuerySourceDTO implements QuerySource {
    private String rawSql;
    private String alias;

    public RawQuerySourceDTO(String rawSql) {
        this.rawSql = rawSql;
    }

    @Override
    public String interpret() {
        return "__FLAIR_RAW([[" + rawSql + "]])" + (alias == null ? "" : " AS " + sanitize(alias));
    }
}
