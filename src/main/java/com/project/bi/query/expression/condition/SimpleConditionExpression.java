package com.project.bi.query.expression.condition;

import com.project.bi.query.dto.ValueTypeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SimpleConditionExpression extends AbstractConditionExpression {

    protected String featureName;

    protected String pickValue(ValueTypeDTO valueType, String value) {
        if (valueType != null) {
            return valueType.interpret();
        }
        return value;
    }

}
