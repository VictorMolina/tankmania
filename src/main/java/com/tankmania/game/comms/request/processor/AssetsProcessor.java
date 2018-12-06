package com.tankmania.game.comms.request.processor;

import com.google.inject.Inject;
import com.tankmania.game.comms.response.MessageBuilder;
import com.tankmania.game.comms.request.Processor;
import com.tankmania.game.comms.request.TankManiaRequestProcessor;
import com.tankmania.game.service.AssetService;
import com.tankmania.proto.TankManiaProtos;

@Processor
public class AssetsProcessor implements TankManiaRequestProcessor {

    private final AssetService assetService;

    @Inject
    public AssetsProcessor(AssetService assetService) {
        this.assetService = assetService;
    }

    @Override
    public boolean isValid(TankManiaProtos.TankManiaRequest request) {
        return request.hasAssetsRequest();
    }

    @Override
    public TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        return MessageBuilder.getAssetsResponse(assetService.getAssets());
    }
}
