package com.project.bi.general;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/10/2017.
 * Refers that entity is applicable on entity with type {@link T}
 */
public interface Applicable<T> {

    /**
     * Apply logic on input
     *
     * @param input that will be changed
     * @return modified input with applied changes
     */
    T apply(T input);
}
