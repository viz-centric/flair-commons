package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.CompositeConditionExpression;

public class AndConditionExpression extends CompositeConditionExpression {

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
        return interpret();
    }

    @Override
    public String interpret() {
        return getFirstExpression().interpret() + " AND " + getSecondExpression().interpret();
    }
}
