package com.project.bi.query.expression.condition.impl;

import com.project.bi.query.SQLUtil;
import com.project.bi.query.expression.condition.CollectionConditionExpression;

import java.util.stream.Collectors;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/26/2017.
 */
public class ContainsConditionExpression extends CollectionConditionExpression {

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    @Override
    public String interpret(String connectionName) {
        StringBuilder str = new StringBuilder();
        if(getFeatureName()!=null) {
        	
        str.append(getFeatureName());
        str.append(" IN (");

        String values = getValues().stream()
                .map(SQLUtil::preProcessValue)
                .collect(Collectors.joining(","));

			str.append(values).append(")");
        }

        return str.toString();
    }

	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		 StringBuilder str = new StringBuilder();
		 if(getFeatureName()!=null) {
	        	
		        str.append(getFeatureName());
		        str.append(" IN (");

		        String values = getValues().stream()
		                .map(SQLUtil::preProcessValue)
		                .collect(Collectors.joining(","));
		        
					if ("".equals(values)) {
						values=null;
					}
					str.append(values).append(")");
		        }

		        return str.toString();
	}
}
