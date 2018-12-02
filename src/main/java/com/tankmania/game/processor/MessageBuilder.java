package com.streetjam.game.processor;

import com.streetjam.game.model.AddressBook;
import com.streetjam.game.model.Person;
import com.streetjam.proto.StreetJamProtos;

public class MessageBuilder {
    public static StreetJamProtos.StreetJamResponse getAddressBookResponse(AddressBook addressBook) {
        StreetJamProtos.AddressBook.Builder addressBookBuilder = StreetJamProtos.AddressBook.newBuilder();
        addressBook.getContacts().forEach(person -> {
            StreetJamProtos.Person.Builder personBuilder = StreetJamProtos.Person.newBuilder();
            personBuilder.setId(person.getId());
            personBuilder.setName(person.getName());
            personBuilder.setEmail(person.getEmail());
            person.getPhones().forEach(phone -> {
                StreetJamProtos.Person.PhoneNumber.Builder phoneNumberBuilder = StreetJamProtos.Person.PhoneNumber.newBuilder();
                phoneNumberBuilder.setNumber(phone.getNumber());
                phoneNumberBuilder.setType(StreetJamProtos.Person.PhoneType.valueOf(phone.getPhoneType().name()));
                personBuilder.addPhones(phoneNumberBuilder.build());
            });
            addressBookBuilder.addPeople(personBuilder.build());
        });
        return StreetJamProtos.StreetJamResponse.newBuilder()
                .setAddressBookResponse(StreetJamProtos.AddressBookResponse.newBuilder()
                        .addAddressBook(addressBookBuilder.build()))
                .build();
    }

    public static StreetJamProtos.StreetJamResponse getAddPersonResponse(Person person) {
        return StreetJamProtos.StreetJamResponse.newBuilder()
                .setAddPersonResponse(StreetJamProtos.AddPersonResponse.newBuilder()
                        .setId(person.getId()))
                .build();
    }
}
