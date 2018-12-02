package com.tankmania.game.processor;

import com.tankmania.proto.TankManiaProtos;

public interface StreetJamRequestProcessor {
    boolean isValid(TankManiaProtos.TankManiaRequest request);
    TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request);
}
