package com.yarolegovich.calc;

/**
 * Created by yarolegovich on 19.12.2015.
 */
public class NegativesNotSupportedException extends IllegalArgumentException {
    public NegativesNotSupportedException(String message) {
        super(message);
    }
}
