package com.streetjam.game.processor;

import com.google.inject.Inject;
import com.streetjam.game.model.Person;
import com.streetjam.game.model.Phone;
import com.streetjam.game.model.PhoneType;
import com.streetjam.game.service.AddressBookService;
import com.streetjam.proto.StreetJamProtos;

import java.util.List;
import java.util.stream.Collectors;

@Processor
public class AddPersonProcessor implements StreetJamRequestProcessor {

    @Inject
    private AddressBookService addressBookService;

    @Override
    public boolean isValid(StreetJamProtos.StreetJamRequest request) {
        return request.hasAddPersonRequest();
    }

    @Override
    public StreetJamProtos.StreetJamResponse process(StreetJamProtos.StreetJamRequest request) {
        String name = request.getAddPersonRequest().getPerson().getName();
        String email = request.getAddPersonRequest().getPerson().getEmail();
        List<Phone> phoneList = request.getAddPersonRequest().getPerson().getPhonesList().stream()
                .map(p -> new Phone(p.getNumber(), PhoneType.valueOf(p.getType().name())))
                .collect(Collectors.toList());

        Person person = addressBookService.addPerson(name, email, phoneList);
        return MessageBuilder.getAddPersonResponse(person);
    }
}
