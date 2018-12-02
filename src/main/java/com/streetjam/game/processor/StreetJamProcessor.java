package com.streetjam.game.processor;

import com.streetjam.game.config.Configuration;
import com.streetjam.proto.StreetJamProtos;
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

    public static StreetJamProtos.StreetJamResponse process(StreetJamProtos.StreetJamRequest request) {
        return requestProcessors.stream().filter(p -> p.isValid(request)).findAny().get().process(request);
    }
}
