package com.project.bi.query.expression.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiplyOperation implements Operation {

    public static final String TYPE = "multiply";

    private Operation operationLeft;
    private OperationSign kind;
    private Operation operationRight;

    public MultiplyOperation(Operation operationLeft) {
        this.operationLeft = operationLeft;
    }

    @Override
    public String interpret() {
        if (kind == null || operationRight == null) {
            return operationLeft.interpret();
        }
        return "("
                + operationLeft.interpret()
                + " "
                + kind.getSign()
                + " "
                + operationRight.interpret()
                + ")";
    }

}
