package com.streetjam.game.service;

import com.google.inject.Inject;
import com.streetjam.game.model.AddressBook;
import com.streetjam.game.model.Person;
import com.streetjam.game.model.Phone;

import java.util.List;

public class AddressBookService {

    @Inject
    private AddressBook addressBook;

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public Person addPerson(String name, String email, List<Phone> phoneList) {
        Person person = new Person(addressBook.nextContactId(), name, email, phoneList);
        addressBook.addContact(person);
        return person;
    }
}
