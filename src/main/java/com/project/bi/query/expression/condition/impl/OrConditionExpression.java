package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.CompositeConditionExpression;

public class OrConditionExpression extends CompositeConditionExpression {


    @Override
    public String interpret() {
        return getFirstExpression().interpret() + " OR " + getSecondExpression().interpret();
    }
}
