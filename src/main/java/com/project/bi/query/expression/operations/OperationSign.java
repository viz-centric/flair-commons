package com.project.bi.query.expression.operations;

import lombok.Getter;

@Getter
public enum OperationSign {
    MULTIPLY("*"), SUBTRACT("-"), ADD("+"), DIVIDE("/");

    private final String sign;

    OperationSign(String sign) {
        this.sign = sign;
    }
}
