package com.project.bi.query.expression.condition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SimpleConditionExpression extends AbstractConditionExpression {

    protected String featureName;

}
