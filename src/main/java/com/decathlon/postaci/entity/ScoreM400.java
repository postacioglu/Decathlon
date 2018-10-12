package com.decathlon.postaci.entity;


public class ScoreM400 implements ScorePoint {

    private static ScoreM400 instance;

    public static final double A_VALUE = 1.53775;
    public static final double B_VALUE = 82;
    public static final double C_VALUE = 1.81;

    private ScoreM400() { }

    public static synchronized ScoreM400 getSingleton()
    {
        if(instance == null){
            instance = new ScoreM400();
        }

        return instance;
    }

    @Override
    public int calcPoint(String performance){

        double P = Double.parseDouble(performance);

        // Points = INT(A(B — P)C):
        return (int) (A_VALUE*Math.pow(((B_VALUE-P)),C_VALUE));

    }

}