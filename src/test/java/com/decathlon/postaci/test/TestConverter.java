package com.decathlon.postaci.test;

import com.decathlon.postaci.entity.DecathlonResults;
import com.decathlon.postaci.utilities.Consts;
import com.decathlon.postaci.utilities.Converter;
import com.decathlon.postaci.utilities.Utilities;
import org.junit.Assert;
import org.junit.Test;

public class TestConverter {

    @Test
    public void test_convert(){

        String oneResultInfo = "Siim Susi;10.395;7.76;18.4;2.20;46.17;13.8;56.17;5.28;77.19;3.53.79";

        String[] resultInfo = oneResultInfo.split(Consts.SEMI_COLON);


        DecathlonResults decathlonResults1 = Converter.convert(resultInfo);
        DecathlonResults decathlonResults2 = createDecathlonResults();

        Assert.assertEquals(decathlonResults1.getFullName(), decathlonResults2.getFullName());
        Assert.assertEquals(decathlonResults1.getDiscusThrow(), decathlonResults2.getDiscusThrow());
        Assert.assertEquals(decathlonResults1.getLongJump(), decathlonResults2.getLongJump());
        Assert.assertEquals(decathlonResults1.getShotPut(), decathlonResults2.getShotPut());
        Assert.assertEquals(decathlonResults1.getHighJump(), decathlonResults2.getHighJump());
        Assert.assertEquals(decathlonResults1.getM400(), decathlonResults2.getM400());
        Assert.assertEquals(decathlonResults1.getM110Hurdles(), decathlonResults2.getM110Hurdles());
        Assert.assertEquals(decathlonResults1.getDiscusThrow(), decathlonResults2.getDiscusThrow());
        Assert.assertEquals(decathlonResults1.getPoleVault(), decathlonResults2.getPoleVault());
        Assert.assertEquals(decathlonResults1.getJavelinThrow(), decathlonResults2.getJavelinThrow());
        Assert.assertEquals(decathlonResults1.getM1500(), decathlonResults2.getM1500());

        Assert.assertEquals(decathlonResults1.getPoints().getDiscusThrowPoint(), decathlonResults2.getPoints().getDiscusThrowPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getLongJumpPoint(), decathlonResults2.getPoints().getLongJumpPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getShotPutPoint(), decathlonResults2.getPoints().getShotPutPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getHighJumpPoint(), decathlonResults2.getPoints().getHighJumpPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getM400Point(), decathlonResults2.getPoints().getM400Point());
        Assert.assertEquals(decathlonResults1.getPoints().getM110HurdlesPoint(), decathlonResults2.getPoints().getM110HurdlesPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getDiscusThrowPoint(), decathlonResults2.getPoints().getDiscusThrowPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getPoleVaultPoint(), decathlonResults2.getPoints().getPoleVaultPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getJavelinThrowPoint(), decathlonResults2.getPoints().getJavelinThrowPoint());
        Assert.assertEquals(decathlonResults1.getPoints().getM1500Point(), decathlonResults2.getPoints().getM1500Point());
        Assert.assertEquals(decathlonResults1.getPoints().getTotalPoint(), decathlonResults2.getPoints().getTotalPoint());

        Assert.assertEquals(decathlonResults1.getPoints(), decathlonResults2.getPoints());


        Assert.assertEquals(decathlonResults1, decathlonResults2);

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
        decathlonResults.setPoints(Utilities.calculatePoints(decathlonResults));

        return decathlonResults;

    }

}