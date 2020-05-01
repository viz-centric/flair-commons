package com.project.bi.query.expression.operations;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ArithmeticOperation extends CompositeOperation {

    public static final String TYPE = "arithmetic";

    private OperationSign value;

    public ArithmeticOperation(List<Operation> operations, OperationSign value) {
        super(operations);
        this.value = value;
    }

    @Override
    public String interpret() {
        if (getOperations().isEmpty()) {
            return "";
        }
        return "(" +
                getOperations()
                        .stream()
                        .map(o -> o.interpret())
                        .collect(Collectors.joining(" " + value.getSign() + " "))
                + ")";
    }

}
