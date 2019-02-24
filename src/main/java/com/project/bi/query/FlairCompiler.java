package com.project.bi.query;

import com.project.bi.general.Compiler;

/**
 * Flair Compiler abstraction
 */
public interface FlairCompiler extends Compiler<FlairQuery> {

    /**
     * Which type of input the compiler supports
     *
     * @return class
     */
    @Override
    default Class<? extends FlairQuery> supports() {
        return FlairQuery.class;
    }
}
