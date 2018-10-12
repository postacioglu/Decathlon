package com.decathlon.postaci.entity;


public class ScoreShotPut implements ScorePoint {

    private static ScoreShotPut instance;

    public static final double A_VALUE = 51.39;
    public static final double B_VALUE = 1.5;
    public static final double C_VALUE = 1.05;

    private ScoreShotPut() { }

    public static synchronized ScoreShotPut getSingleton()
    {
        if(instance == null){
            instance = new ScoreShotPut();
        }

        return instance;
    }

    @Override
    public int calcPoint(String performance){

        double P = Double.parseDouble(performance);

        // Points = INT(A(P — B)C):
        return (int) (A_VALUE*Math.pow(((P-B_VALUE)),C_VALUE));

    }
}