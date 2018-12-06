package com.tankmania.game.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tankmania.game.model.Asset;
import com.tankmania.game.store.AssetStore;

import java.io.InputStreamReader;
import java.util.List;

public class Configuration extends AbstractModule {

    private static Injector injector = Guice.createInjector(new Configuration());

    @Override
    protected void configure() {
        super.configure();
        bind(AssetStore.class).toInstance(new AssetStore(readAssets()));
    }

    public static <T> T getInstance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }

    private List<Asset> readAssets() {
        JsonReader reader = new JsonReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets.json")));
        return new Gson().fromJson(reader, new TypeToken<List<Asset>>(){}.getType());
    }
}
