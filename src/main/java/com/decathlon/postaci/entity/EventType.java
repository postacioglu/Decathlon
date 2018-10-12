package com.decathlon.postaci.entity;

public enum EventType {

    M100("M100"),		            // 100 m
    LONGJUMP("LONGJUMP"),		    // Long Jump
    SHOTPUT("SHOTPUT"),		        // Shot put
    HIGHJUMP("HIGHJUMP"),		    // High Jump
    M400("M400"),		            // 400 m
    M110HURDLES("M110HURDLES"),		// 110 m hurdles
    DISCUSTHROW("DISCUSTHROW"),		// Discus Throw
    POLEVAULT("POLEVAULT"),		    // Pole Vault
    JAVELINTHROW("JAVELINTHROW"),   // Javelin throw
    M1500("M1500");                 // 1500 m


    private String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public static EventType toEnum(String eventType) {
        for (EventType item : EventType.values()) {
            if(item.getEventType().equals(eventType))
                return item;
        };

        return null;
    }

}