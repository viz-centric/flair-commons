package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/12/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BetweenConditionExpression extends SimpleConditionExpression {

    protected String value;

    protected String secondValue;


    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
    	if(getFeatureName()==null) {
    		return "";
    	}
        return getFeatureName() + " BETWEEN " + SQLUtil.preProcessValue(getValue()) + " AND " + SQLUtil.preProcessValue(getSecondValue());
    }


	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		if(getFeatureName()==null) {
    		return "";
    	}
        
		return getFeatureName() + " BETWEEN " + SQLUtil.preProcessValue(getValue()) + " AND " + SQLUtil.preProcessValue(getSecondValue());
	}
}
