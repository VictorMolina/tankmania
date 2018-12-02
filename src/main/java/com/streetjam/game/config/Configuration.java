package com.streetjam.game.config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.streetjam.game.model.AddressBook;
import com.streetjam.game.service.AddressBookService;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Configuration extends AbstractModule {

    private static Injector injector = Guice.createInjector(new Configuration());

    @Override
    protected void configure() {
        super.configure();
        bind(AddressBook.class).toInstance(new AddressBook(new CopyOnWriteArrayList<>()));
    }

    public static <T> T getInstance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
