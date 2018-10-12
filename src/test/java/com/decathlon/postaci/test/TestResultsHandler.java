package com.decathlon.postaci.test;

import com.decathlon.postaci.entity.DecathlonResults;
import com.decathlon.postaci.impl.DecathlonScoringHandler;
import com.decathlon.postaci.utilities.Consts;
import com.decathlon.postaci.utilities.Converter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestResultsHandler {

    @Test
    public void test_retrieveResults() throws Exception{

        String csvFileInput = "InputOutputFiles/resultsInput.csv";

        String[] decathlonResultsInfos = {"Siim Susi;10.395;7.76;18.4;2.20;46.17;13.8;56.17;5.28;77.19;3.53.79",
                                          "Beata Kana;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76",
                                          "Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75",
                                          "Anti Loop;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01"};




        List<DecathlonResults> decathlonResultsList1 = DecathlonScoringHandler.retrieveResults(csvFileInput);
        List<DecathlonResults> decathlonResultsList2 = new ArrayList();

        for(int i = 0; i < decathlonResultsInfos.length; i++){

            String[] resultStr = decathlonResultsInfos[i].split(Consts.SEMI_COLON);

            DecathlonResults decathlonResults = Converter.convert(resultStr);

            decathlonResultsList2.add(decathlonResults);

        }

        Assert.assertEquals(decathlonResultsList1, decathlonResultsList2);
        Assert.assertEquals(decathlonResultsList1.size(), decathlonResultsList2.size());

    }

    @Test(expected = Exception.class)
    public void test_retrieveResults2() throws Exception{

        String csvFileInput = "InputOutputFiles/resultsCorruptedInput.csv";

        DecathlonScoringHandler.retrieveResults(csvFileInput);

    }


    @Test
    public void test_rankResults() throws Exception{

        String csvFileInput = "InputOutputFiles/resultsInput.csv";

        String splittter = Consts.DASH;

        List<DecathlonResults> decathlonResultsList = DecathlonScoringHandler.retrieveResults(csvFileInput);
        List<DecathlonResults> sortedDecathlonResultsList = DecathlonScoringHandler.rankResults(decathlonResultsList);

        boolean assertionRanked = true;

        if(sortedDecathlonResultsList.size() > 0 && sortedDecathlonResultsList.size() > 1) {

            for (int i = 0; i < sortedDecathlonResultsList.size() - 1; i++) {

                if (sortedDecathlonResultsList.get(i).getPoints().getTotalPoint() < sortedDecathlonResultsList.get(i + 1).getPoints().getTotalPoint()) {

                    String[] sortedDecathlonResults1 = sortedDecathlonResultsList.get(i).getRank().split(splittter);
                    String[] sortedDecathlonResults2 = sortedDecathlonResultsList.get(i+1).getRank().split(splittter);

                    if (!(Integer.valueOf(sortedDecathlonResults1[sortedDecathlonResults1.length-1]) < Integer.valueOf(sortedDecathlonResults2[sortedDecathlonResults2.length-1]))) {

                        assertionRanked = false;
                        break;
                    }
                } else if (sortedDecathlonResultsList.get(i).getPoints().getTotalPoint() == sortedDecathlonResultsList.get(i + 1).getPoints().getTotalPoint()) {

                    if (!sortedDecathlonResultsList.get(i).getRank().equals(sortedDecathlonResultsList.get(i + 1).getRank())) {

                        assertionRanked = false;
                        break;
                    }
                } else {

                    assertionRanked = false;
                    break;
                }

            }
        }


        Assert.assertTrue(assertionRanked);

    }

    @Test
    public void test_sort2() throws Exception{

        String csvFileInput = "InputOutputFiles/resultsMultiRankedInput.csv";

        String splittter = Consts.DASH;

        List<DecathlonResults> decathlonResultsList = DecathlonScoringHandler.retrieveResults(csvFileInput);
        List<DecathlonResults> sortedDecathlonResultsList = DecathlonScoringHandler.rankResults(decathlonResultsList);

        boolean assertionRanked = true;

        if(sortedDecathlonResultsList.size() > 0 && sortedDecathlonResultsList.size() > 1) {

            for (int i = 0; i < sortedDecathlonResultsList.size() - 1; i++) {

                if (sortedDecathlonResultsList.get(i).getPoints().getTotalPoint() < sortedDecathlonResultsList.get(i + 1).getPoints().getTotalPoint()) {

                    String[] sortedDecathlonResults1 = sortedDecathlonResultsList.get(i).getRank().split(splittter);
                    String[] sortedDecathlonResults2 = sortedDecathlonResultsList.get(i+1).getRank().split(splittter);

                    if (!(Integer.valueOf(sortedDecathlonResults1[sortedDecathlonResults1.length-1]) < Integer.valueOf(sortedDecathlonResults2[sortedDecathlonResults2.length-1]))) {

                        assertionRanked = false;
                        break;
                    }
                } else if (sortedDecathlonResultsList.get(i).getPoints().getTotalPoint() == sortedDecathlonResultsList.get(i + 1).getPoints().getTotalPoint()) {

                    if (!sortedDecathlonResultsList.get(i).getRank().equals(sortedDecathlonResultsList.get(i + 1).getRank())) {

                        assertionRanked = false;
                        break;
                    }
                } else {

                    assertionRanked = false;
                    break;
                }

            }
        }


        Assert.assertTrue(assertionRanked);

    }

    @Test
    public void test_saveResultsToXLSFile() throws Exception{

        String xlsFileOut = "InputOutputFiles/testsOut.xml";

        String[] decathlonResultsInfos = {"Siim Susi;10.395;7.76;18.4;2.20;46.17;13.8;56.17;5.28;77.19;3.53.79",
                                          "Beata Kana;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76",
                                          "Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75",
                                           "Anti Loop;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01"};





        List<DecathlonResults> decathlonResultsList = new ArrayList();

        for(int i = 0; i < decathlonResultsInfos.length; i++){

            String[] athleteStr = decathlonResultsInfos[i].split(Consts.SEMI_COLON);

            DecathlonResults athlete = Converter.convert(athleteStr);

            decathlonResultsList.add(athlete);

        }

        List<DecathlonResults> sortedAthleteList = DecathlonScoringHandler.rankResults(decathlonResultsList);

        DecathlonScoringHandler.saveResultsToXLSFile(xlsFileOut,sortedAthleteList);

        File cvsOutputFile = new File(xlsFileOut);


        Assert.assertTrue(cvsOutputFile.exists());

    }

}