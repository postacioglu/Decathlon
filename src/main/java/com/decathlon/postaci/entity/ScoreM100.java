package com.decathlon.postaci.entity;


public class ScoreM100 implements ScorePoint {

    private static ScoreM100 instance;

    public static final double A_VALUE = 25.4347;
    public static final double B_VALUE = 18;
    public static final double C_VALUE = 1.81;

    private ScoreM100() { }

    public static synchronized ScoreM100 getSingleton()
    {
        if(instance == null){
            instance = new ScoreM100();
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