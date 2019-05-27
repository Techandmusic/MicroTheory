package com.apps.adampate.microtheory;

import java.util.ArrayList;

//Creates note scale based on key selected by user

public class NoteScale
{
    private ArrayList<String> octave = new ArrayList<String>()
    {
        {
            add("C");
            add("C#");
            add("D");
            add("D#");
            add("E");
            add("F");
            add("G");
            add("G#");
            add("A");
            add("Bb");
            add("B");
            add("B#");
        }
    };

    private String key;
    private String note;

    public NoteScale(String key)
    {
        this.key = key;
        buildOctave(key);
    }

    public ArrayList<String> buildOctave(String key)
    {
        while (octave.get(0) != key) {
            toEnd();
        }
        return octave;
    }

    public void toEnd()
    {
        String temp = octave.get(0);
        octave.remove(0);
        octave.add(temp);

    }

    public String getNote(int position)
    {
        note = octave.get(position);
        return note;
    }


}
