package com.tankmania.game.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AddressBook {

    private final List<Person> contacts;
    private final AtomicLong index;

    public AddressBook(List<Person> contacts) {
        this.contacts = contacts;
        this.index = new AtomicLong(contacts.size());
    }

    public List<Person> getContacts() {
        return Collections.unmodifiableList(contacts);
    }

    public long nextContactId() {
        return index.incrementAndGet();
    }

    public void addContact(Person person) {
        contacts.add(person);
    }
}
