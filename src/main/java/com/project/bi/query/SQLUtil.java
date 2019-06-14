package com.project.bi.query;

import com.project.bi.query.dto.QueryFieldDTO;
import com.project.bi.query.dto.QueryFieldTypeDTO;
import com.project.bi.query.expression.condition.impl.CompareConditionExpression;

public class SQLUtil {
    /**
     * Get comparison operator for given comparator type
     * <p>
     * e.g. EQ gives =
     *
     * @param comparatorType Comparator type
     * @return SQL comparison operator
     */
    public static String getSQLComparatorTypeSymbol(CompareConditionExpression.ComparatorType comparatorType) {
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
                throw new IllegalArgumentException("Corresponding symbol to given comparator type not found");

        }
    }

    /**
     * Checks whether value is digit or varchar
     *
     * @param value value to be checked
     * @return true if valid is digit, false otherwise
     */
    public static boolean isDigit(String value) {
        return value.matches("\\d*\\.?\\d*");
    }

    /**
     * Add '' if value is string otherwise ignore
     *
     * @param value value to be pre-processed
     * @return Pre-processed value
     */
    public static String preProcessValue(String value) {
        if (isDigit(value))
            return value;
        else
            return "'" + value + "'";
    }

    /**
     * Casts column to varchar if the value is digit
     *
     * @param columnName  column to be casted
     * @param columnValue value to be checked
     * @return casted column or unchanged
     */
    public static String preProcessLikeColumn(String columnName, String columnValue) {
        if (isDigit(columnValue)) {
            return columnName + "::VARCHAR(255)";
        } else {
            return columnName;
        }

    }

    public static String sanitizeString(String string) {
        if (string == null) {
            return null;
        }
        if ("".equalsIgnoreCase(string)) {
            return "";
        }
        return string
                .replaceAll("'", "''");
    }

    public static String sanitizeField(QueryFieldDTO field) {
        if (field == null) {
            return null;
        }
        if (field.getType() == QueryFieldTypeDTO.SANITIZE) {
            return sanitizeString(field.getName());
        }
        return field.getName();
    }
}
