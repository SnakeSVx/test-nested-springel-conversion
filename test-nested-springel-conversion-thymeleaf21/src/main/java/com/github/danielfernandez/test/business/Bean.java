package com.github.danielfernandez.test.business;

/**
 * Created by daniel on 04/02/17.
 */
public class Bean {


    private AbstractField fieldAbs = null;
    private Field fieldConc = null;

    public Bean() {
        super();
    }


    public AbstractField getFieldAbs() {
        return this.fieldAbs;
    }

    public void setFieldAbs(final AbstractField fieldAbs) {
        this.fieldAbs = fieldAbs;
    }

    public Field getFieldConc() {
        return this.fieldConc;
    }

    public void setFieldConc(final Field fieldConc) {
        this.fieldConc = fieldConc;
    }

}
