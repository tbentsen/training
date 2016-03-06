package com.tbentsen.training.domain;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
abstract public class BaseEntity {
    public static class JsonViewContext {
        public interface Summary {}
        public interface Detailed extends Summary{}
    }

    @Id
    protected String id;

    public void setId(String id) {
        this.id = id;
    }
}