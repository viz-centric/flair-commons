package com.project.bi.general;

/**
 * Indicates that implemented class is able to build certain type {@link T}
 */
public interface Builder<T> {

    /**
     * Construct given type {@link T}
     *
     * @return type {@link T}
     */
    T build();
}
