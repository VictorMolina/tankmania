package com.tankmania.game.comms.request.processor;

import com.tankmania.game.comms.response.MessageBuilder;
import com.tankmania.game.comms.request.Processor;
import com.tankmania.game.comms.request.TankManiaRequestProcessor;
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
