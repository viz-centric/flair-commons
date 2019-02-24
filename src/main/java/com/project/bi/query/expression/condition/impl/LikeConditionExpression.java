package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.expression.condition.SimpleConditionExpression;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/29/2017.
 */
@Getter
@Setter
public class LikeConditionExpression extends SimpleConditionExpression {

    protected String value;

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
    	String q="";
    	if(getFeatureName()!=null) {
        q= getFeatureName() +
                " LIKE " ;
        if(connectionName.contains("MongoDB"))
        	q+="'.*" + getValue() + ".*'";
        else 
        	q+="'%" + getValue() + "%'";
    	}
    	return q;
    }

	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		String q="";
    	if(getFeatureName()!=null) {
        q= getFeatureName() +
                " LIKE " +
                "'%" + getValue() + "%'";
    	}
    	return q;
	}
}
