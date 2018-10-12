package com.decathlon.postaci.impl;

import com.decathlon.postaci.entity.DecathlonResults;

import java.util.List;

public class DecathlonScoring {

    public static void processDecathlonData(String inputFile, String outputFile) throws  Exception{

        // Read from the file, parse & objectify every item in the file, and insert them to list:
        List<DecathlonResults> decathlonResultsLists = DecathlonScoringHandler.retrieveResults(inputFile);

        // Rank the results in the list:
        decathlonResultsLists = DecathlonScoringHandler.rankResults(decathlonResultsLists);

        // Save the ranked results to file:
        DecathlonScoringHandler.saveResultsToXLSFile(outputFile, decathlonResultsLists);

    }
}
