package com.project.bi.query.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.bi.general.Interpretable;
import com.project.bi.query.SQLUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        defaultImpl = ValueDTO.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ValueTypeDTO.class, name = "valueType"),
        @JsonSubTypes.Type(value = LikeFeatureNameDTO.class, name = "likeValueType"),
        @JsonSubTypes.Type(value = IntervalValueTypeDTO.class, name = "intervalValueType"),
})
public class ValueDTO implements Interpretable {

    private String value;

    public String interpret() {
        return SQLUtil.preProcessValue(value);
    }
}
