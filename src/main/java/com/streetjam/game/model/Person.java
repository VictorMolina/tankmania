package com.streetjam.game.model;

import java.util.Collections;
import java.util.List;

public class Person {
    private final long id;
    private final String name;
    private final String email;
    private final List<Phone> phones;

    public Person(long id, String name, String email, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phones = Collections.unmodifiableList(phones);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
