package com.project.bi.query.expression.condition;

import com.project.bi.query.dto.QueryFieldDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CollectionConditionExpression extends SimpleConditionExpression {

    protected List<QueryFieldDTO> values;

}
