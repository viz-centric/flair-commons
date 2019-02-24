package com.project.bi.query.expression.condition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CompositeConditionExpression extends AbstractConditionExpression {

    protected ConditionExpression firstExpression;

    protected ConditionExpression secondExpression;

}
