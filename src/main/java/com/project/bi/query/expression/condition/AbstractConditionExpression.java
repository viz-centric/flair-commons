package com.project.bi.query.expression.condition;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class AbstractConditionExpression implements ConditionExpression,
        Serializable {

    protected String uuid;

    /**
     * Get identifier expression
     *
     * @return identifier in string representation
     */
    @Override
    public String getIdentifier() {
        return uuid;
    }
}
