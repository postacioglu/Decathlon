package com.decathlon.postaci.utilities;

import com.decathlon.postaci.entity.DecathlonResults;
import com.decathlon.postaci.entity.EventType;
import com.decathlon.postaci.entity.Points;

public class Utilities {

    public static Points calculatePoints(DecathlonResults athlete){

        Points points = new Points();

        ScoreFactory scoreFactory = new ScoreFactory();

        points.setM100Point(scoreFactory.getEvent(EventType.M100).calcPoint(athlete.getM100()));
        points.setLongJumpPoint(scoreFactory.getEvent(EventType.LONGJUMP).calcPoint(athlete.getLongJump()));
        points.setShotPutPoint(scoreFactory.getEvent(EventType.SHOTPUT).calcPoint(athlete.getShotPut()));
        points.setHighJumpPoint(scoreFactory.getEvent(EventType.HIGHJUMP).calcPoint(athlete.getHighJump()));
        points.setM400Point(scoreFactory.getEvent(EventType.M400).calcPoint(athlete.getM400()));
        points.setM110HurdlesPoint(scoreFactory.getEvent(EventType.M110HURDLES).calcPoint(athlete.getM110Hurdles()));
        points.setDiscusThrowPoint(scoreFactory.getEvent(EventType.DISCUSTHROW).calcPoint(athlete.getDiscusThrow()));
        points.setPoleVaultPoint(scoreFactory.getEvent(EventType.POLEVAULT).calcPoint(athlete.getPoleVault()));
        points.setJavelinThrowPoint(scoreFactory.getEvent(EventType.JAVELINTHROW).calcPoint(athlete.getJavelinThrow()));
        points.setM1500Point(scoreFactory.getEvent(EventType.M1500).calcPoint(athlete.getM1500()));
        points.setTotalPoint(calcTotalPoint(points));

        return points;
    }

    public static int calcTotalPoint(Points points){

        int totalPoints = 0;

        totalPoints += points.getM100Point();
        totalPoints += points.getLongJumpPoint();
        totalPoints += points.getShotPutPoint();
        totalPoints += points.getHighJumpPoint();
        totalPoints += points.getM400Point();
        totalPoints += points.getM110HurdlesPoint();
        totalPoints += points.getDiscusThrowPoint();
        totalPoints += points.getPoleVaultPoint();
        totalPoints += points.getJavelinThrowPoint();
        totalPoints += points.getM1500Point();


        return totalPoints;
    }

    public static double stringToTotalSeconds(String minutesSeconds){

        String splitter = Consts.DOT_SPLITTER;
        String[] minutesAndSeconds = minutesSeconds.split(splitter);

        int minutes = Integer.valueOf(minutesAndSeconds[0]);
        double seconds = Double.parseDouble(minutesAndSeconds[1].concat(".").concat(minutesAndSeconds[2]));

        return (minutes*60) + seconds;
    }


    public static String calcRank(int rank, int frequency){

        String returnVal = new String();

        for(int i = 0; i < frequency; i++){

            if(i == 0){

                returnVal = String.valueOf(rank);
            }
            else{

                rank++;

                returnVal = returnVal.concat("-").concat(String.valueOf(rank));
            }

        }

        return returnVal;

    }

}