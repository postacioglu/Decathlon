package com.decathlon.postaci.entity;


public class ScoreM110Hurdles implements ScorePoint {

    private static ScoreM110Hurdles instance;

    public static final double A_VALUE = 5.74352;
    public static final double B_VALUE = 28.5;
    public static final double C_VALUE = 1.92;

    private ScoreM110Hurdles() { }

    public static synchronized ScoreM110Hurdles getSingleton()
    {
        if(instance == null){
            instance = new ScoreM110Hurdles();
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