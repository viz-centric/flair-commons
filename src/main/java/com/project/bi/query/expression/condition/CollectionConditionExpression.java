package com.project.bi.query.expression.condition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/26/2017.
 * <p>
 * Expression that has collection of criterias
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CollectionConditionExpression extends SimpleConditionExpression {


    protected List<String> values;

}
