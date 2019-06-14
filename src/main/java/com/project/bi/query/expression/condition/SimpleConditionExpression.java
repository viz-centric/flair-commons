package com.project.bi.query.expression.condition;

import com.project.bi.query.dto.QueryFieldDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SimpleConditionExpression extends AbstractConditionExpression {

    protected QueryFieldDTO featureName;

}
