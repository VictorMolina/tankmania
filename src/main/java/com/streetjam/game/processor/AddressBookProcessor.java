package com.streetjam.game.processor;

import com.google.inject.Inject;
import com.streetjam.game.model.AddressBook;
import com.streetjam.game.service.AddressBookService;
import com.streetjam.proto.StreetJamProtos;

@Processor
public class AddressBookProcessor implements StreetJamRequestProcessor {

    @Inject
    private AddressBookService addressBookService;

    @Override
    public boolean isValid(StreetJamProtos.StreetJamRequest request) {
        return request.hasAddressBookRequest();
    }

    @Override
    public StreetJamProtos.StreetJamResponse process(StreetJamProtos.StreetJamRequest request) {
        Long personId = request.getAddressBookRequest().getId();
        AddressBook addressBook = addressBookService.getAddressBook();
        return MessageBuilder.getAddressBookResponse(addressBook);
    }
}
