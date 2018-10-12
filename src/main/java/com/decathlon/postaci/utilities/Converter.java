package com.decathlon.postaci.utilities;

import com.decathlon.postaci.entity.DecathlonResults;

public class Converter {


    public static DecathlonResults convert(String[] arr){

        DecathlonResults decathlonResults = null;

        if(arr != null && arr.length != 0){

            decathlonResults = new DecathlonResults();

            decathlonResults.setFullName(arr[0]);
            decathlonResults.setM100(arr[1]);
            decathlonResults.setLongJump(arr[2]);
            decathlonResults.setShotPut(arr[3]);
            decathlonResults.setHighJump(arr[4]);
            decathlonResults.setM400(arr[5]);
            decathlonResults.setM110Hurdles(arr[6]);
            decathlonResults.setDiscusThrow(arr[7]);
            decathlonResults.setPoleVault(arr[8]);
            decathlonResults.setJavelinThrow(arr[9]);
            decathlonResults.setM1500(arr[10]);
            decathlonResults.setPoints(Utilities.calculatePoints(decathlonResults));
        }

        return decathlonResults;
    }

}