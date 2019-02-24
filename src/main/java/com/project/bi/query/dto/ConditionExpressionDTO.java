package com.project.bi.query.dto;


import com.project.bi.query.expression.condition.ConditionExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/14/2017.
 * Wrapper around {@link ConditionExpression} defining source type
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConditionExpressionDTO {

    private SourceType sourceType;

    private ConditionExpression conditionExpression;

    /**
     * Defined from which sources condition expression comes
     */
    public static enum SourceType {
        BASE,
        FILTER,
        REDUCTION
    }


}
