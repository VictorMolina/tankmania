package com.streetjam.game.processor;

import com.streetjam.proto.StreetJamProtos;

public interface StreetJamRequestProcessor {
    boolean isValid(StreetJamProtos.StreetJamRequest request);
    StreetJamProtos.StreetJamResponse process(StreetJamProtos.StreetJamRequest request);
}
