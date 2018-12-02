package com.tankmania.game.model;

public class Phone {
    private final String number;
    private final PhoneType phoneType;

    public Phone(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }
}
