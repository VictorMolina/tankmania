package com.tankmania.gameserver.processors;

import com.tankmania.proto.TankManiaProtos;

public interface TankManiaRequestProcessor {
    TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request);
}
