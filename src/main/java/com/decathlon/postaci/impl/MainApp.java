package com.decathlon.postaci.impl;


public class MainApp {

    public static void main(String[] args) {
        try {

            String csvFileInput = "InputOutputFiles/resultsMultiRankedInput.csv";
            String xlsFileOutput = "InputOutputFiles/resultsOut.xml";

            // Start the app asking for the input and output files:
            DecathlonScoring.processDecathlonData(csvFileInput, xlsFileOutput);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}