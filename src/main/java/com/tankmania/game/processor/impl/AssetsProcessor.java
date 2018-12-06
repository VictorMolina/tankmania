package com.tankmania.game.processor.impl;

import com.google.inject.Inject;
import com.tankmania.game.processor.MessageBuilder;
import com.tankmania.game.processor.Processor;
import com.tankmania.game.processor.TankManiaRequestProcessor;
import com.tankmania.game.service.AssetService;
import com.tankmania.proto.TankManiaProtos;

@Processor(requestCase = TankManiaProtos.TankManiaResponse.ASSETS_RESPONSE_FIELD_NUMBER)
public class AssetsProcessor implements TankManiaRequestProcessor {

    private final AssetService assetService;

    @Inject
    public AssetsProcessor(AssetService assetService) {
        this.assetService = assetService;
    }

    @Override
    public TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        return MessageBuilder.getAssetsResponse(assetService.getAssets());
    }
}
