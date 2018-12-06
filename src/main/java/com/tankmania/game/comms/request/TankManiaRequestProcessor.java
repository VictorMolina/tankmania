package com.tankmania.game.comms.request;

import com.tankmania.proto.TankManiaProtos;

public interface TankManiaRequestProcessor {
    boolean isValid(TankManiaProtos.TankManiaRequest request);
    TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request);
}
