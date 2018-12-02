package com.tankmania.game.processor;

import com.tankmania.game.model.AddressBook;
import com.tankmania.game.model.Person;
import com.tankmania.proto.TankManiaProtos;

public class MessageBuilder {
    public static TankManiaProtos.TankManiaResponse getAddressBookResponse(AddressBook addressBook) {
        TankManiaProtos.AddressBook.Builder addressBookBuilder = TankManiaProtos.AddressBook.newBuilder();
        addressBook.getContacts().forEach(person -> {
            TankManiaProtos.Person.Builder personBuilder = TankManiaProtos.Person.newBuilder();
            personBuilder.setId(person.getId());
            personBuilder.setName(person.getName());
            personBuilder.setEmail(person.getEmail());
            person.getPhones().forEach(phone -> {
                TankManiaProtos.Person.PhoneNumber.Builder phoneNumberBuilder = TankManiaProtos.Person.PhoneNumber.newBuilder();
                phoneNumberBuilder.setNumber(phone.getNumber());
                phoneNumberBuilder.setType(TankManiaProtos.Person.PhoneType.valueOf(phone.getPhoneType().name()));
                personBuilder.addPhones(phoneNumberBuilder.build());
            });
            addressBookBuilder.addPeople(personBuilder.build());
        });
        return TankManiaProtos.TankManiaResponse.newBuilder()
                .setAddressBookResponse(TankManiaProtos.AddressBookResponse.newBuilder()
                        .addAddressBook(addressBookBuilder.build()))
                .build();
    }

    public static TankManiaProtos.TankManiaResponse getAddPersonResponse(Person person) {
        return TankManiaProtos.TankManiaResponse.newBuilder()
                .setAddPersonResponse(TankManiaProtos.AddPersonResponse.newBuilder()
                        .setId(person.getId()))
                .build();
    }
}
