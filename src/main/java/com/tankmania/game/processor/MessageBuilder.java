package com.tankmania.game.processor;

import com.tankmania.game.model.Asset;
import com.tankmania.proto.TankManiaProtos;

import java.util.List;

public class MessageBuilder {
    public static TankManiaProtos.TankManiaResponse getVersionResponse() {
        return TankManiaProtos.TankManiaResponse.newBuilder()
                .setVersionResponse(TankManiaProtos.VersionResponse.newBuilder().setVersion("0.0.1"))
                .build();
    }

    public static TankManiaProtos.TankManiaResponse getAssetsResponse(List<Asset> assets) {
        TankManiaProtos.AssetsResponse.Builder builder = TankManiaProtos.AssetsResponse.newBuilder();
        assets.stream().forEach(asset -> builder.addAsset(TankManiaProtos.Asset.newBuilder()
                .setName(asset.getName())
                .setVersion(asset.getVersion())
                .setUrl(asset.getUrl())));
        return TankManiaProtos.TankManiaResponse.newBuilder()
                .setAssetsResponse(builder)
                .build();
    }
}
