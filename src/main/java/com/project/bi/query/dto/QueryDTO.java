package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import com.project.bi.query.expression.condition.ConditionExpression;
import com.project.bi.query.expression.condition.impl.AndConditionExpression;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 8/10/2017.
 * Data transfer object that used to transfer query data between flair-bi and fbiengine
 */
@Getter
@Setter
public class QueryDTO implements Interpretable {

    @NotNull
    private String source;
    /*
        sum(price) as price
     */
    private List<String> fields = new ArrayList<>();
    private List<String> groupBy = new ArrayList<>();
    private Long limit;
    private List<ConditionExpressionDTO> conditionExpressions = new ArrayList<>();
    private boolean distinct;
    private List<SortDTO> orders = new ArrayList<>();

    private boolean metaRetrieved;

    public String interpret(String connectionName) {
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT ")
                .append(distinct ? "DISTINCT " : "")
                .append(fields.isEmpty() ? "*" : fields.stream().filter(s-> s!=null).collect(Collectors.joining(",")))
                .append(" FROM ")
                .append(source);

        ConditionExpression where = mergeConditionExpression();

        if (null != where) {
            builder.append(" WHERE ")
                    .append(where.interpret(connectionName));
        }

        if (!groupBy.isEmpty()) {
            builder
                    .append(" GROUP BY ")
                    .append(groupBy.stream().filter(s-> s!=null).collect(Collectors.joining(",")));

        }

        if (!orders.isEmpty()) {
            builder.append(" ORDER BY ")
                    .append(orders.stream().filter(s-> s!=null).map(SortDTO::interpret).collect(Collectors.joining(",")));

        }

        if (null != limit && !"Oracle-connection".equalsIgnoreCase(connectionName)) {
            builder.append(" LIMIT ")
                    .append(limit);
        }
        else if(null != limit) {
        	builder.append(" FETCH NEXT "+limit+" ROWS ONLY ");
        }
        


        return builder.toString();
    }


    private ConditionExpression mergeConditionExpression() {
        ConditionExpression conditionExpression = null;
        boolean first = true;

        for (ConditionExpressionDTO dto : conditionExpressions) {
            if (first) {
                conditionExpression = dto.getConditionExpression();
                first = false;
            } else {
                AndConditionExpression and = new AndConditionExpression();
               
                and.setFirstExpression(conditionExpression);
                and.setSecondExpression(dto.getConditionExpression());
                conditionExpression = and;
            }	
        }

        return conditionExpression;
    }


	@Override
	public String interpret() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();

        builder.append("SELECT ")
                .append(distinct ? "DISTINCT " : "")
                .append(fields.isEmpty() ? "*" : fields.stream().collect(Collectors.joining(",")))
                .append(" FROM ")
                .append(source);

        ConditionExpression where = mergeConditionExpression();

       
        if (null != where) {
            builder.append(" WHERE ")
                    .append(where.interpret());
        }

        if (!groupBy.isEmpty()) {
            builder
                    .append(" GROUP BY ")
                    .append(groupBy.stream().collect(Collectors.joining(",")));

        }

        if (!orders.isEmpty()) {
            builder.append(" ORDER BY ")
                    .append(orders.stream().map(SortDTO::interpret).collect(Collectors.joining(",")));

        }

        if (null != limit ) {
            builder.append(" LIMIT ")
                    .append(limit);
        }
        


        return builder.toString();
	}


	

}
