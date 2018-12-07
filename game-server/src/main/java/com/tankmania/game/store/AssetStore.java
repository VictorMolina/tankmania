package com.tankmania.game.store;

import com.tankmania.game.model.Asset;

import java.util.List;

public class AssetStore {

    private final List<Asset> assets;

    public AssetStore(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Asset> getAssets() {
        return assets;
    }
}
