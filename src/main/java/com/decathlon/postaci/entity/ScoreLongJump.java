package com.decathlon.postaci.entity;


public class ScoreLongJump implements ScorePoint {

    private static ScoreLongJump instance;

    public static final double A_VALUE = 0.14354;
    public static final double B_VALUE = 220;
    public static final double C_VALUE = 1.4;

    private ScoreLongJump() { }

    public static synchronized ScoreLongJump getSingleton()
    {
        if(instance == null){
            instance = new ScoreLongJump();
        }

        return instance;
    }

    @Override
    public int calcPoint(String performance){

        double P = Double.parseDouble(performance) * 100;

        // Points = INT(A(P — B)C):
        return (int) (A_VALUE*Math.pow(((P-B_VALUE)),C_VALUE));

    }
}