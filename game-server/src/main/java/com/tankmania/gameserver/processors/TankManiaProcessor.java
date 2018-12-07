package com.tankmania.gameserver.processors;

import com.tankmania.common.config.Configuration;
import com.tankmania.proto.TankManiaProtos;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class TankManiaProcessor {

    private static final Map<Integer, TankManiaRequestProcessor> requestProcessors;

    static {
        requestProcessors = new HashMap<>();
        Reflections reflections = new Reflections();
        reflections.getTypesAnnotatedWith(Processor.class).forEach(clazz -> {
            int index = clazz.getAnnotation(Processor.class).requestCase();
            TankManiaRequestProcessor processor = Configuration.getInstance((Class<TankManiaRequestProcessor>) clazz);
            requestProcessors.put(index, processor);
        });
    }

    public static TankManiaProtos.TankManiaResponse process(TankManiaProtos.TankManiaRequest request) {
        return requestProcessors.get(request.getRequestCase().getNumber()).process(request);
    }
}
