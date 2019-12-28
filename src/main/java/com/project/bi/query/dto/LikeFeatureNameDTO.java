package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeFeatureNameDTO implements Interpretable {
    private String featureName;
    private String type;

    @Override
    public String interpret() {
        return "__FLAIR_CAST(" + type + ", " + featureName + ")";
    }
}
