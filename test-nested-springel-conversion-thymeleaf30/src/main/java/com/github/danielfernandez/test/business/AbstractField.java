package com.github.danielfernandez.test.business;

/**
 * Created by daniel on 04/02/17.
 */
public abstract class AbstractField {

    private final int value;


    public AbstractField(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Unconverted field with value '" + this.value + "'";
    }

}
