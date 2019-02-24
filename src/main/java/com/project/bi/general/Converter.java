package com.project.bi.general;

/**
 * Class that converts from type {@link I} to type {@link O}
 *
 * @param <I> type of input
 * @param <O> type of output
 */
public interface Converter<I, O> {

    /**
     * Convert given input to output
     *
     * @param data input data
     * @return output
     */
    O convert(I data);
}
