package com.project.bi.general;

/**
 * Interprets certain statements and facts into string
 */
public interface Interpretable {

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    String interpret();
    
    String interpret(String connectionName);
}
