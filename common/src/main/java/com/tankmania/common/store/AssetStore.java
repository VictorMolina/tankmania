package com.tankmania.common.store;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tankmania.common.model.Asset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AssetStore {

    private final List<Asset> assets;

    public AssetStore() {
        this.assets = readAssets();
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets() {

    }

    private List<Asset> readAssets() {
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream("c://assets.json")));
            return new Gson().fromJson(reader, new TypeToken<List<Asset>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Asset>();
        }
    }
}
