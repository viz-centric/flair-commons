package com.project.bi.general;

/**
 * @author Stefan Bratić cobrijani@gmail.com
 * Created on 9/27/2017.
 * <p>
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
