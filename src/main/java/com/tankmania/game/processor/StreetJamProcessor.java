package com.tankmania.game.processor;

import com.tankmania.game.config.Configuration;
import com.tankmania.proto.TankManiaProtos;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class StreetJamProcessor {

    private static final Set<StreetJamRequestProcessor> requestProcessors;

    static {
        requestProcessors = new HashSet<>();
        Reflections reflections = new Reflections();
        reflections.getTypesAnnotatedWith(Processor.class).forEach(clazz -> {
            requestProcessors.add(Configuration.getInstance((Class<StreetJamRequestProcessor>) clazz));
        });
    }

    public static TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        return requestProcessors.stream().filter(p -> p.isValid(request)).findAny().get().process(request);
    }
}
