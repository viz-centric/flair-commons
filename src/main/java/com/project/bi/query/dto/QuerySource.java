package com.project.bi.query.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.bi.general.Interpretable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = QuerySourceDTO.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = QuerySourceDTO.class, name = "table"),
        @JsonSubTypes.Type(value = RawQuerySourceDTO.class, name = "raw")}
)
public interface QuerySource extends Interpretable {
}
