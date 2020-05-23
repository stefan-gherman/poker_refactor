package com.codecool.customexception;

/**
 * <p>Custom exception to be raised when input does not follow required patterns</p>
 * @author Fane Martiru StringBuilder, Domn si Voievod al Tarilor Romane, Archon in Antioch
 */
public class IllegalInputException extends Exception {
    public IllegalInputException(String message) {
        super(message);
    }
}
