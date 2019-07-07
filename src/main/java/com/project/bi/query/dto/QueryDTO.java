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
 * Data transfer object that used to transfer query data between flair-bi and fbiengine
 */
@Getter
@Setter
public class QueryDTO implements Interpretable {

    @NotNull
    private String source;
    private List<String> fields = new ArrayList<>();
    private List<String> groupBy = new ArrayList<>();
    private Long limit;
    private List<HavingDTO> having = new ArrayList<>();
    private List<ConditionExpressionDTO> conditionExpressions = new ArrayList<>();
    private boolean distinct;
    private List<SortDTO> orders = new ArrayList<>();
    private boolean metaRetrieved;

    public QueryDTO() {
    }

    public QueryDTO(QueryDTO queryDTO) {
        this.source = queryDTO.getSource();
        this.fields = new ArrayList<>(queryDTO.getFields());
        this.groupBy = new ArrayList<>(queryDTO.getGroupBy());
        this.limit = queryDTO.getLimit();
        this.conditionExpressions = new ArrayList<>(queryDTO.getConditionExpressions());
        this.distinct = queryDTO.isDistinct();
        this.orders = new ArrayList<>(queryDTO.getOrders());
        this.metaRetrieved = queryDTO.isMetaRetrieved();
    }

    @Deprecated
    public String interpret(String connectionName) {
        return interpret();
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
		StringBuilder builder = new StringBuilder();

        builder.append("SELECT ")
                .append(distinct ? "DISTINCT " : "")
                .append(fields.isEmpty() ? "*" : fields.stream().map(it -> it).collect(Collectors.joining(",")))
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

        if (!having.isEmpty()) {
            builder
                    .append(" HAVING ")
                    .append(having.stream().map(HavingDTO::interpret).collect(Collectors.joining(" AND ")));
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
