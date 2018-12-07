package com.tankmania.gameserver.processors.impl;

import com.tankmania.gameserver.processors.MessageBuilder;
import com.tankmania.gameserver.processors.Processor;
import com.tankmania.gameserver.processors.TankManiaRequestProcessor;
import com.tankmania.proto.TankManiaProtos;

@Processor(requestCase = TankManiaProtos.TankManiaRequest.VERSION_REQUEST_FIELD_NUMBER)
public class VersionProcessor implements TankManiaRequestProcessor {

    @Override
    public TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        return MessageBuilder.getVersionResponse();
    }
}
