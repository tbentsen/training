package com.tbentsen.training.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.mongodb.morphia.converters.SimpleValueConverter;
import org.mongodb.morphia.converters.TypeConverter;
import org.mongodb.morphia.mapping.MappedField;
import org.mongodb.morphia.mapping.MappingException;

public class JodaDateTimeConverter extends TypeConverter implements SimpleValueConverter {

    public JodaDateTimeConverter() {
        super(DateTime.class);
    }

    @Override
    public Object decode(Class<?> clazz, Object from, MappedField arg2) throws MappingException {
        if (from == null) {
            return null;
        }

        if (from instanceof Date) {
            Date d = (Date) from;
            return new DateTime(d.getTime());
        }

        throw new RuntimeException(from.getClass().getName());
    }

    @Override
    public Object encode(Object value, MappedField arg2) throws MappingException {
        if (value == null) {
            return null;
        }

        if (!(value instanceof DateTime)) {
            throw new RuntimeException(
                    "Did not expect " + value.getClass().getName());
        }

        DateTime dateTime = (DateTime) value;
        return dateTime.toDate();
    }
    
}