package com.tankmania.common.config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Configuration extends AbstractModule {

    private static Injector injector = Guice.createInjector(new Configuration());

    @Override
    protected void configure() {
        super.configure();
    }

    public static <T> T getInstance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
