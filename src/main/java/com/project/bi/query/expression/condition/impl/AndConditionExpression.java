package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.CompositeConditionExpression;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/12/2017.
 */
public class AndConditionExpression extends CompositeConditionExpression {


    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
        return getFirstExpression().interpret(connectionName) + " AND " + getSecondExpression().interpret(connectionName);
    }

	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		 return getFirstExpression().interpret() + " AND " + getSecondExpression().interpret();
	}
}
