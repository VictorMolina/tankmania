package com.tankmania.game.processor;

import com.google.inject.Inject;
import com.tankmania.game.model.Person;
import com.tankmania.game.model.Phone;
import com.tankmania.game.model.PhoneType;
import com.tankmania.game.service.AddressBookService;
import com.tankmania.proto.TankManiaProtos;

import java.util.List;
import java.util.stream.Collectors;

@Processor
public class AddPersonProcessor implements StreetJamRequestProcessor {

    @Inject
    private AddressBookService addressBookService;

    @Override
    public boolean isValid(TankManiaProtos.TankManiaRequest request) {
        return request.hasAddPersonRequest();
    }

    @Override
    public TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        String name = request.getAddPersonRequest().getPerson().getName();
        String email = request.getAddPersonRequest().getPerson().getEmail();
        List<Phone> phoneList = request.getAddPersonRequest().getPerson().getPhonesList().stream()
                .map(p -> new Phone(p.getNumber(), PhoneType.valueOf(p.getType().name())))
                .collect(Collectors.toList());

        Person person = addressBookService.addPerson(name, email, phoneList);
        return MessageBuilder.getAddPersonResponse(person);
    }
}
