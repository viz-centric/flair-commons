package com.project.bi.query;


import lombok.Value;

@Value
public class FlairQuery {

    /**
     * Query statement
     */
    private String statement;

    private boolean pullMeta;

    private String source;

    private boolean isCacheEnabled;
}
