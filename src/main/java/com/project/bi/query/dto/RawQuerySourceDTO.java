package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawQuerySourceDTO implements QuerySource {
    private String rawSql;

    @Override
    public String interpret() {
        return "__FLAIR_RAW([[" + rawSql + "]])";
    }
}
