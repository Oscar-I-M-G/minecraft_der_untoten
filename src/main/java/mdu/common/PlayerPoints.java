package mdu.common;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerPoints {
    // server side memory storage ??
    private static final Map<UUID, Integer> POINTS = new HashMap<>();

    public static void add(UUID playerId, int ammount){
        POINTS.put(playerId, get(playerId) + ammount);
    }

    public static void set(UUID playerId, int value){
        POINTS.put(playerId, value);
    }

    public static int get(UUID playerId){
        return POINTS.getOrDefault(playerId, 0);
    }

    public static void remove(UUID playerId){
        POINTS.remove(playerId);
    }

    public static void resetAll(){
        POINTS.clear();
    }
}
