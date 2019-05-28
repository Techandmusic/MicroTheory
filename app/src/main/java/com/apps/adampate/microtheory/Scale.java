package com.apps.adampate.microtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scale
{
    private Map<String, String> scaleMap = new HashMap<>();
    private String tonality;
    private ArrayList<String> newScale;

    public Scale(Map<String, String> scaleMap, String tonality)
    {
        this.scaleMap = scaleMap;
        this.tonality = tonality;
    }

    public ArrayList<String> makeScale()
    {
        //Add logic to choose tonality and create scale based on that
        return newScale;
    }
}
