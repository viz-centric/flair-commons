package com.project.bi.query.expression.condition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.bi.query.expression.Expression;
import com.project.bi.query.expression.condition.impl.*;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/12/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OrConditionExpression.class, name = "Or"),
        @JsonSubTypes.Type(value = BetweenConditionExpression.class, name = "Between"),
        @JsonSubTypes.Type(value = CompareConditionExpression.class, name = "Compare"),
        @JsonSubTypes.Type(value = AndConditionExpression.class, name = "And"),
        @JsonSubTypes.Type(value = ContainsConditionExpression.class, name = "Contains"),
        @JsonSubTypes.Type(value = NotContainsConditionExpression.class, name = "NotContains"),
        @JsonSubTypes.Type(value = LikeConditionExpression.class, name = "Like")}
)

public interface ConditionExpression extends Expression {


}
