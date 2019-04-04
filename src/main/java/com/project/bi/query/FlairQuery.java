package com.project.bi.query;


public class FlairQuery {

    private String statement;
    private boolean pullMeta;
    private String source;

    public FlairQuery(String statement, boolean pullMeta) {
        this.statement = statement;
        this.pullMeta = pullMeta;
        this.source = null;
    }

    public FlairQuery(String statement, boolean pullMeta, String source) {
        this.statement = statement;
        this.pullMeta = pullMeta;
        this.source = source;
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

}
