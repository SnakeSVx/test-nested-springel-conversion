package com.github.danielfernandez.test.conversion;

import java.text.ParseException;
import java.util.Locale;

import com.github.danielfernandez.test.business.Field;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 * Created by daniel on 04/02/17.
 */
@Component
public class FieldFormatter implements Formatter<Field> {


    @Override
    public Field parse(final String text, final Locale locale) throws ParseException {
        return new Field(Integer.parseInt(text));
    }

    @Override
    public String print(final Field object, final Locale locale) {
        return "(FORMATTED: '" + object.getValue() + "')";
    }

}
