package com.project.bi.query;


public class FlairQuery {

    private String statement;
    private boolean pullMeta;
    private String source;
    private boolean isCacheEnabled;

    public FlairQuery(String statement, boolean pullMeta) {
        this.statement = statement;
        this.pullMeta = pullMeta;
        this.source = null;
        this.isCacheEnabled = false;
    }

    public FlairQuery(String statement, boolean pullMeta, String source, boolean isCacheEnabled) {
        this.statement = statement;
        this.pullMeta = pullMeta;
        this.source = source;
        this.isCacheEnabled = isCacheEnabled;
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

    public boolean isCacheEnabled() {
        return isCacheEnabled;
    }

    public void setCacheEnabled(boolean cacheEnabled) {
        isCacheEnabled = cacheEnabled;
    }
}
