package com.project.bi.query.expression.operations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.bi.general.Interpretable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MultiplyOperation.class, name = MultiplyOperation.TYPE),
        @JsonSubTypes.Type(value = ScalarOperation.class, name = ScalarOperation.TYPE),
        @JsonSubTypes.Type(value = QueryOperation.class, name = QueryOperation.TYPE),
})
public interface Operation extends Interpretable {
}
