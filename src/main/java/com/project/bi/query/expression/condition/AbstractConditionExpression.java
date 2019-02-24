package com.project.bi.query.expression.condition;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/12/2017.
 */
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
