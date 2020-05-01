package com.project.bi.query.expression.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class CompositeOperation implements Operation {

    private List<Operation> operations;

}
