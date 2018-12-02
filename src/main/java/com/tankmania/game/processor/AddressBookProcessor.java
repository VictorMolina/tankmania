package com.tankmania.game.processor;

import com.google.inject.Inject;
import com.tankmania.game.model.AddressBook;
import com.tankmania.game.service.AddressBookService;
import com.tankmania.proto.TankManiaProtos;

@Processor
public class AddressBookProcessor implements StreetJamRequestProcessor {

    @Inject
    private AddressBookService addressBookService;

    @Override
    public boolean isValid(TankManiaProtos.TankManiaRequest request) {
        return request.hasAddressBookRequest();
    }

    @Override
    public TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        Long personId = request.getAddressBookRequest().getId();
        AddressBook addressBook = addressBookService.getAddressBook();
        return MessageBuilder.getAddressBookResponse(addressBook);
    }
}
