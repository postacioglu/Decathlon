package com.decathlon.postaci.test;

import com.decathlon.postaci.entity.DecathlonResults;
import com.decathlon.postaci.entity.Points;
import com.decathlon.postaci.utilities.Utilities;
import org.junit.Test;
import org.junit.Assert;

public class TestUtilities {

   @Test
    public void test_calculatePoints(){

       DecathlonResults athlete = this.createDecathlonResults();

       Points points = Utilities.calculatePoints(athlete);

       int m100Point = 1000;
       int longJumpPoint = 1000;
       int shotPutPoint = 1000;
       int highJumpPoint = 992;
       int m400Point = 1000;
       int m110HurdlesPoint = 1000;
       int discusThrowPoint = 1000;
       int poleVaultPoint = 998;
       int javelinThrowPoint = 1000;
       int m1500Point = 1000;
       int totalPoint = 9990;

       Assert.assertEquals(m100Point, points.getM100Point());
       Assert.assertEquals(longJumpPoint, points.getLongJumpPoint());
       Assert.assertEquals(shotPutPoint, points.getShotPutPoint());
       Assert.assertEquals(highJumpPoint, points.getHighJumpPoint());
       Assert.assertEquals(m400Point, points.getM400Point());
       Assert.assertEquals(m110HurdlesPoint, points.getM110HurdlesPoint());
       Assert.assertEquals(discusThrowPoint, points.getDiscusThrowPoint());
       Assert.assertEquals(poleVaultPoint, points.getPoleVaultPoint());
       Assert.assertEquals(javelinThrowPoint, points.getJavelinThrowPoint());
       Assert.assertEquals(m1500Point, points.getM1500Point());
       Assert.assertEquals(totalPoint, points.getTotalPoint());

   }

    @Test
    public void test_calcRank_1(){

      int rank = 7;
      int frequency = 1;

      String expectedResult = "7";

      Assert.assertEquals(expectedResult, Utilities.calcRank(rank, frequency));

    }

    @Test
    public void test_calcRank_2(){

        int rank = 7;
        int frequency = 3;

        String expectedResults = "7-8-9";

        Assert.assertEquals(expectedResults, Utilities.calcRank(rank, frequency));
    }

   public DecathlonResults createDecathlonResults(){

       DecathlonResults decathlonResults = new DecathlonResults();

       decathlonResults.setFullName("Siim Susi");
       decathlonResults.setM100("10.395");
       decathlonResults.setLongJump("7.76");
       decathlonResults.setShotPut("18.4");
       decathlonResults.setHighJump("2.20");
       decathlonResults.setM400("46.17");
       decathlonResults.setM110Hurdles("13.8");
       decathlonResults.setDiscusThrow("56.17");
       decathlonResults.setPoleVault("5.28");
       decathlonResults.setJavelinThrow("77.19");
       decathlonResults.setM1500("3.53.79");

       return decathlonResults;
   }

}