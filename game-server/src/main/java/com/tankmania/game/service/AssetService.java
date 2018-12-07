package com.tankmania.game.service;

import com.google.inject.Inject;
import com.tankmania.game.model.Asset;
import com.tankmania.game.store.AssetStore;

import java.util.List;

public class AssetService {

    private final AssetStore assetStore;

    @Inject
    public AssetService(AssetStore assetStore) {
        this.assetStore = assetStore;
    }
    public List<Asset> getAssets() {
        return assetStore.getAssets();
    }
}
