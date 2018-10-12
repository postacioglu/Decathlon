package com.decathlon.postaci.impl;


import com.decathlon.postaci.entity.DecathlonResults;
import com.decathlon.postaci.utilities.Consts;
import com.decathlon.postaci.utilities.Converter;
import com.sun.org.apache.xerces.internal.dom.ProcessingInstructionImpl;
import com.decathlon.postaci.utilities.Utilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecathlonScoringHandler {


    public static List<DecathlonResults> retrieveResults(String cvsFileLocation) throws  Exception{

        List<DecathlonResults> decathlonResultsList = new ArrayList<DecathlonResults>();

        BufferedReader bufferedReader = null;
        String semiColonSplitter = Consts.SEMI_COLON;
        String line = Consts.EMPTY_STRING;

        bufferedReader = new BufferedReader(new FileReader(cvsFileLocation));
        while ((line = bufferedReader.readLine()) != null) {

            String[] scores = line.split(semiColonSplitter);

            if(scores.length != Consts.NO_OF_SCORES_PER_ATHLETE){
                throw new Exception("File does not obey the decathlon results standards or has empty lines. Change the file!");
            }

            // Add every athlete object to list:

            decathlonResultsList.add(Converter.convert(scores));
        }

        bufferedReader.close();

        return decathlonResultsList;

    }

    public static List<DecathlonResults> rankResults(List<DecathlonResults> decathlonResultsList){

        Collections.sort(decathlonResultsList, new DecathlonResults());

        int rank = 1;

        // rank the athletes and share the places:  e.g. 3-4 and 3-4 instead of 3 and 4
        for(int i = 0; i < decathlonResultsList.size();){

            int frequency = Collections.frequency(decathlonResultsList, decathlonResultsList.get(i));

            String rankStr = Utilities.calcRank(rank, frequency);

            for(int k = 0; k < frequency; k++){

                decathlonResultsList.get(i).setRank(rankStr);

                rank++;
                i++;
            }

        }

        return decathlonResultsList;

    }

    public static void saveResultsToXLSFile(String xslFileLocation, List<DecathlonResults> decathlonResultsList){

        try{

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();


            Document document = documentBuilder.newDocument();
            document.setXmlStandalone(true);


            ProcessingInstructionImpl processingInstruction = (ProcessingInstructionImpl) document
                    .createProcessingInstruction(Consts.XML_STYLESHEET, Consts.XSL_STYLER);

            Element root = document.getDocumentElement();
            document.insertBefore((Node) processingInstruction, root);

            // XMLify the decathlonResultsList:

            Element resultsElement = document.createElement(Consts.XML_ELEMENT_RESULTS);
            document.appendChild(resultsElement);



            for(DecathlonResults decathlonResults: decathlonResultsList) {

                Element ranks = document.createElement(Consts.XML_ELEMENT_RANKS);
                resultsElement.appendChild(ranks);

                Element ranked = document.createElement(Consts.XML_ELEMENT_RANKED);
                ranked.appendChild(document.createTextNode(decathlonResults.getRank()));
                ranks.appendChild(ranked);

                Element fullName = document.createElement(Consts.XML_ELEMENT_FULL_NAME);
                fullName.appendChild(document.createTextNode(decathlonResults.getFullName()));
                ranks.appendChild(fullName);

                Element m100 = document.createElement(Consts.XML_ELEMENT_M_110);
                m100.appendChild(document.createTextNode(decathlonResults.getM100()));
                ranks.appendChild(m100);

                Element longJump = document.createElement(Consts.XML_ELEMENT_LONG_JUMP);
                longJump.appendChild(document.createTextNode(decathlonResults.getLongJump()));
                ranks.appendChild(longJump);

                Element shotPut = document.createElement(Consts.XML_ELEMENT_SHOT_PUT);
                shotPut.appendChild(document.createTextNode(decathlonResults.getShotPut()));
                ranks.appendChild(shotPut);

                Element highJump = document.createElement(Consts.XML_ELEMENT_HIGH_JUMP);
                highJump.appendChild(document.createTextNode(decathlonResults.getHighJump()));
                ranks.appendChild(highJump);

                Element m400 = document.createElement(Consts.XML_ELEMENT_M_400);
                m400.appendChild(document.createTextNode(decathlonResults.getM400()));
                ranks.appendChild(m400);

                Element m110Hurdles = document.createElement(Consts.XML_ELEMENT_M_110_HURDLES);
                m110Hurdles.appendChild(document.createTextNode(decathlonResults.getM110Hurdles()));
                ranks.appendChild(m110Hurdles);

                Element discusThrow = document.createElement(Consts.XML_ELEMENT_DISCUS_THROW);
                discusThrow.appendChild(document.createTextNode(decathlonResults.getDiscusThrow()));
                ranks.appendChild(discusThrow);

                Element poleVault = document.createElement(Consts.XML_ELEMENT_POLE_VAULT);
                poleVault.appendChild(document.createTextNode(decathlonResults.getPoleVault()));
                ranks.appendChild(poleVault);

                Element javelinThrow = document.createElement(Consts.XML_ELEMENT_JAVELIN_THROW);
                javelinThrow.appendChild(document.createTextNode(decathlonResults.getJavelinThrow()));
                ranks.appendChild(javelinThrow);

                Element m1500 = document.createElement(Consts.XML_ELEMENT_M_1500);
                m1500.appendChild(document.createTextNode(decathlonResults.getM1500()));
                ranks.appendChild(m1500);

                Element totalScore = document.createElement(Consts.XML_ELEMENT_TOTAL_SCORE);
                totalScore.appendChild(document.createTextNode(String.valueOf(decathlonResults.getPoints().getTotalPoint())));
                ranks.appendChild(totalScore);
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xslFileLocation));


            String yes = "yes";

            transformer.setOutputProperty(OutputKeys.INDENT, yes);
            transformer.setOutputProperty(OutputKeys.STANDALONE, yes);

            transformer.transform(source, result);


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}