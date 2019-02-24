package com.project.bi.general;

import com.project.bi.exceptions.ExecutionException;

import java.io.Writer;

/**
 * Responsible for executing
 *
 * @param <T> type of input that the executor receives
 */
public interface Executor<T> {

    /**
     * Execute a logic with given input
     *
     * @param input  input that is used in execution
     * @param writer writer that handles writing the result of execution
     * @throws ExecutionException when execution fails
     */
    void execute(T input, Writer writer) throws ExecutionException;

}
