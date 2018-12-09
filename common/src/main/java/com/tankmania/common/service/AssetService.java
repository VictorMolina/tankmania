package com.tankmania.common.service;

import com.google.inject.Inject;
import com.tankmania.common.model.Asset;
import com.tankmania.common.store.AssetStore;

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

    public void setAssets(String content) {
        assetStore.setAssets(content);
    }
}
