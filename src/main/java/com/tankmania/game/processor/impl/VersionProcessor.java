package com.tankmania.game.processor.impl;

import com.tankmania.game.processor.MessageBuilder;
import com.tankmania.game.processor.Processor;
import com.tankmania.game.processor.TankManiaRequestProcessor;
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
