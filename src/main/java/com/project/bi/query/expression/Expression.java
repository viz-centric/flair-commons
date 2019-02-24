package com.project.bi.query.expression;

import com.project.bi.general.Interpretable;

public interface Expression extends Interpretable {

    /**
     * Get identifier expression
     *
     * @return identifier in string representation
     */
    String getIdentifier();
}
