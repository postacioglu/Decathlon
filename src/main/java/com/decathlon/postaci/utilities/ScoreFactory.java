package com.decathlon.postaci.utilities;

import com.decathlon.postaci.entity.*;

public class ScoreFactory {

    public ScorePoint getEvent(EventType eventType){

        if(eventType == null){
            return null;
        }
        if(eventType.equals(EventType.M100)){
            return ScoreM100.getSingleton();

        } else if(eventType.equals(EventType.LONGJUMP)){
            return ScoreLongJump.getSingleton();

        } else if(eventType.equals(EventType.SHOTPUT)){
            return ScoreShotPut.getSingleton();

        } else if(eventType.equals(EventType.HIGHJUMP)){
            return ScoreHighJump.getSingleton();

        } else if(eventType.equals(EventType.M400)){
            return ScoreM400.getSingleton();

        } else if(eventType.equals(EventType.M110HURDLES)){
            return ScoreM110Hurdles.getSingleton();

        } else if(eventType.equals(EventType.DISCUSTHROW)){
            return ScoreDiscusThrow.getSingleton();

        }else if(eventType.equals(EventType.POLEVAULT)){
            return ScorePoleVault.getSingleton();

        }else if(eventType.equals(EventType.JAVELINTHROW)){
            return ScoreJavelinThrow.getSingleton();

        }else if(eventType.equals(EventType.M1500)){
            return ScoreM1500.getSingleton();

        }

        return null;
    }

}