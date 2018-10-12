package com.decathlon.postaci.entity;


public class ScoreHighJump implements ScorePoint {

    private static ScoreHighJump instance;

    public static final double A_VALUE = 0.8465;
    public static final double B_VALUE = 75;
    public static final double C_VALUE = 1.42;

    private ScoreHighJump() { }

    public static synchronized ScoreHighJump getSingleton()
    {
        if(instance == null){
            instance = new ScoreHighJump();
        }

        return instance;
    }

    @Override
    public int calcPoint(String performance){

        double P = Double.parseDouble(performance)*100;

        // Points = INT(A(P — B)C):
        return (int) (A_VALUE*Math.pow(((P-B_VALUE)),C_VALUE));

    }

}