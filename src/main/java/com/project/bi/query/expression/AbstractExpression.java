package com.project.bi.query.expression;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class AbstractExpression implements Expression {

    protected String identifier;

    public AbstractExpression() {
        this.identifier = UUID.randomUUID().toString();
    }

    /**
     * Get identifier expression
     *
     * @return identifier in string representation
     */
    @Override
    public String getIdentifier() {
        return this.identifier;
    }
}
