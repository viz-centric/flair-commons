package com.project.bi.general;

import com.project.bi.exceptions.CompilationException;

import java.io.Writer;

/**
 * Class representing a compiler
 */
public interface Compiler<I> {

    /**
     * Compiles input to write to to the writer
     *
     * @param input  input used for compiling
     * @param writer writer that receives the result of compilation
     * @throws CompilationException if compilation fails
     */
    void compile(I input, Writer writer) throws CompilationException;

    /**
     * Which type of input the compiler supports
     *
     * @return class
     */
    Class<? extends I> supports();

}
