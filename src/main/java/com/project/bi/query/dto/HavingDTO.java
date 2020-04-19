package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import com.project.bi.query.SQLUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private String value;
    private ComparatorType comparatorType;
    private QueryExpDTO valueQuery;

    @Getter
    @RequiredArgsConstructor
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
                (valueQuery != null ? "(" + valueQuery.interpret() + ")" : SQLUtil.preProcessValue(value));
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
