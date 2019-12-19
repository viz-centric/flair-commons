package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeFeatureNameDTO {
    private String featureName;
    private String type;

    public String interpret() {
        return "__FLAIR_CAST(" + type + ", " + featureName + ")";
    }
}
