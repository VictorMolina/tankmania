package com.tankmania.game.processor;

import com.tankmania.proto.TankManiaProtos;

@Processor
public class VersionProcessor implements TankManiaRequestProcessor {

    @Override
    public boolean isValid(TankManiaProtos.TankManiaRequest request) {
        return request.hasVersionRequest();
    }

    @Override
    public TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        return MessageBuilder.getVersionResponse();
    }
}
