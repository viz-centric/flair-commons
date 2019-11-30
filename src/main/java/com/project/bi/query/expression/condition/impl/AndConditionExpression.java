package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.CompositeConditionExpression;

public class AndConditionExpression extends CompositeConditionExpression {

    @Override
    public String interpret() {
        return getFirstExpression().interpret() + " AND " + getSecondExpression().interpret();
    }
}
