package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import com.project.bi.query.expression.operations.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HavingDTO implements Interpretable {

    private FieldDTO feature;
    private ComparatorType comparatorType;
    private Operation operation;

    public enum ComparatorType {
        UNKNOWN,
        EQ,
        NEQ,
        GT,
        LT,
        GTE,
        LTE;
    }

    @Override
    public String interpret() {
        return feature.interpret() +
                " " +
                getSQLComparatorTypeSymbol(comparatorType) +
                " " +
                operation.interpret();
    }

    private String getSQLComparatorTypeSymbol(ComparatorType comparatorType) {
        switch (comparatorType) {
            case EQ:
                return "=";
            case GT:
                return ">";
            case LT:
                return "<";
            case GTE:
                return ">=";
            case LTE:
                return "<=";
            case NEQ:
                return "<>";
            default:
                throw new IllegalArgumentException("Corresponding symbol " + comparatorType + " to given comparator type not found");
        }
    }
}
