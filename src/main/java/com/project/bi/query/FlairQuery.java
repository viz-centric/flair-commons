package com.project.bi.query;


import com.project.bi.query.dto.QueryDTO;

public class FlairQuery {

    private final String statement;
    private final boolean pullMeta;
    private final String source;
    private final QueryDTO queryDTO;

    public FlairQuery(String statement, boolean pullMeta) {
        this(statement, pullMeta, null);
    }

    public FlairQuery(String statement, boolean pullMeta, String source) {
        this.statement = statement;
        this.pullMeta = pullMeta;
        this.source = source;
        this.queryDTO = null;
    }

    public FlairQuery(QueryDTO queryDTO) {
        this.statement = queryDTO.interpret();
        this.pullMeta = queryDTO.isMetaRetrieved();
        this.source = queryDTO.getSource();
        this.queryDTO = queryDTO;
    }

    public String getStatement() {
        return statement;
    }

    public boolean isPullMeta() {
        return pullMeta;
    }

    public String getSource() {
        return source;
    }

    public QueryDTO getQueryDTO() {
        return queryDTO;
    }
}
