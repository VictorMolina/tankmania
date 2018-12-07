package com.tankmania.game.processor;

import com.tankmania.proto.TankManiaProtos;

public interface TankManiaRequestProcessor {
    TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request);
}
