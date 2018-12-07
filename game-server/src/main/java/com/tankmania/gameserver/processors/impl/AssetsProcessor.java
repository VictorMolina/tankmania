package com.tankmania.gameserver.processors.impl;

import com.google.inject.Inject;
import com.tankmania.gameserver.processors.MessageBuilder;
import com.tankmania.gameserver.processors.Processor;
import com.tankmania.gameserver.processors.TankManiaRequestProcessor;
import com.tankmania.common.service.AssetService;
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
