package com.decathlon.postaci.entity;


public class ScoreDiscusThrow implements ScorePoint {

    private static ScoreDiscusThrow instance;

    public static final double A_VALUE = 12.91;
    public static final double B_VALUE = 4;
    public static final double C_VALUE = 1.1;

    private ScoreDiscusThrow() { }

    public static synchronized ScoreDiscusThrow getSingleton()
    {
        if(instance == null){
            instance = new ScoreDiscusThrow();
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