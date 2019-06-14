package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.dto.QueryFieldDTO;
import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.Getter;
import lombok.Setter;

import static com.project.bi.query.SQLUtil.sanitizeField;

@Getter
@Setter
public class LikeConditionExpression extends SimpleConditionExpression {

    protected QueryFieldDTO value;

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
        return interpret();
    }

    @Override
    public String interpret() {
        String q = "";
        if (getFeatureName() != null) {
            q = sanitizeField(getFeatureName()) +
                    " LIKE " +
                    "'%" + sanitizeField(getValue()) + "%'";
        }
        return q;
    }
}
