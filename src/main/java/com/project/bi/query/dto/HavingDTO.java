package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import com.project.bi.query.SQLUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class HavingDTO implements Interpretable {

    private final String featureName;
    private final String value;
    private final ComparatorType comparatorType;

    @Override
    public String interpret(String connectionName) {
        return interpret();
    }

    @Getter
    @RequiredArgsConstructor
    public enum ComparatorType {

        EQ("eq"),
        NEQ("neq"),
        GT("gt"),
        LT("lt"),
        GTE("gte"),
        LTE("lte");

        private final String value;
    }

    @Override
    public String interpret() {
        return new StringBuilder()
                .append("(")
                .append(featureName)
                .append(" ")
                .append(getSQLComparatorTypeSymbol(comparatorType))
                .append(" ")
                .append(SQLUtil.preProcessValue(value))
                .append(")")
                .toString();
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
