package com.decathlon.postaci.entity;


import com.decathlon.postaci.utilities.Utilities;

public class ScoreM1500 implements ScorePoint {

    private static ScoreM1500 instance;

    public static final double A_VALUE = 0.03768;
    public static final double B_VALUE = 480;
    public static final double C_VALUE = 1.85;


    private ScoreM1500() { }

    public static synchronized ScoreM1500 getSingleton()
    {
        if(instance == null){
            instance = new ScoreM1500();
        }

        return instance;
    }

    @Override
    public int calcPoint(String performance){

        double P = Utilities.stringToTotalSeconds(performance);

        // Points = INT(A(B — P)C):
        return (int) (A_VALUE*Math.pow(((B_VALUE-P)),C_VALUE));

    }

}