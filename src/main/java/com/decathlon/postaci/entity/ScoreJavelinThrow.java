package com.decathlon.postaci.entity;


public class ScoreJavelinThrow implements ScorePoint {

    private static ScoreJavelinThrow instance;

    public static final double A_VALUE = 10.14;
    public static final double B_VALUE = 7;
    public static final double C_VALUE = 1.08;

    private ScoreJavelinThrow() { }

    public static synchronized ScoreJavelinThrow getSingleton()
    {
        if(instance == null){
            instance = new ScoreJavelinThrow();
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