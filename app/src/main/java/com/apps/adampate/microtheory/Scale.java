package com.apps.adampate.microtheory;

import java.util.ArrayList;
import java.util.Map;

public class Scale
{
    private Map<String, String> scaleMap;
    private int tonality;
    private ArrayList<String> newScale;


    public Scale(Map<String, String> scaleMap, String key, int tonality)
    {
        this.scaleMap = scaleMap;
        this.tonality = tonality;
        Chromatic chromatic = new Chromatic(key);
        scaleMap = chromatic.getChromatic();
        makeScale(tonality);
    }

    public ArrayList<String> makeScale(int tone)
    {
        switch (tone) {
            case 1:
                //Major scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("fourth"));
                newScale.add(scaleMap.get("fifth"));
                newScale.add(scaleMap.get("majorSixth"));
                newScale.add(scaleMap.get("majorSeventh"));
                break;
            case 2:
                //Minor scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("minorThird"));
                newScale.add(scaleMap.get("fourth"));
                newScale.add(scaleMap.get("fifth"));
                newScale.add(scaleMap.get("minorSixth"));
                newScale.add(scaleMap.get("minorSeventh"));
                break;
            case 3:
                //Blues scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("minorThird"));
                newScale.add(scaleMap.get("fourth"));
                newScale.add(scaleMap.get("flatFifth"));
                newScale.add(scaleMap.get("fifth"));
                newScale.add(scaleMap.get("minorSeventh"));
                break;
            case 4:
                //Pentatonic scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("fifth"));
                newScale.add(scaleMap.get("majorSixth"));
                break;
            default:
                return null;

        }

        return newScale;
    }
}
