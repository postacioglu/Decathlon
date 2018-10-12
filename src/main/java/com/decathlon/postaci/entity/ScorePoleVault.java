package com.decathlon.postaci.entity;


public class ScorePoleVault implements ScorePoint {

    private static ScorePoleVault instance;

    public static final double A_VALUE = 0.2797;
    public static final double B_VALUE = 100;
    public static final double C_VALUE = 1.35;

    private ScorePoleVault() { }

    public static synchronized ScorePoleVault getSingleton()
    {
        if(instance == null){
            instance = new ScorePoleVault();
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