package com.tankmania.game.config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tankmania.game.model.Asset;
import com.tankmania.game.store.AssetStore;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Configuration extends AbstractModule {

    private static Injector injector = Guice.createInjector(new Configuration());

    @Override
    protected void configure() {
        super.configure();

        List<Asset> initialTestAssets = new CopyOnWriteArrayList<>();
        initialTestAssets.add(new Asset("MAIN_BACKGROUND", "0.0.1", "https://www.domain.es/main/background/tankmania.png"));

        bind(AssetStore.class).toInstance(new AssetStore(initialTestAssets));
    }

    public static <T> T getInstance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
