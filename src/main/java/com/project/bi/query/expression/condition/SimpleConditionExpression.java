package com.project.bi.query.expression.condition;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.dto.ValueDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SimpleConditionExpression extends AbstractConditionExpression {

    protected String featureName;

    protected String pickValue(ValueDTO valueType, String value) {
        if (valueType != null) {
            return valueType.interpret();
        }
        return SQLUtil.preProcessValue(value);
    }

}
