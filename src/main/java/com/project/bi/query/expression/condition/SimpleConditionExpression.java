package com.project.bi.query.expression.condition;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/12/2017.
 */
@Getter
@Setter
public abstract class SimpleConditionExpression extends AbstractConditionExpression {

    protected String featureName;

}
