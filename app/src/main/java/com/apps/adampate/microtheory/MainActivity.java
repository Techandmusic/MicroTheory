package com.apps.adampate.microtheory;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String rootNote;
    //Scale scale;
    int tone;
    ArrayList<String> notes;
    TextView noteView;
    Button btn;
    RadioGroup radioGroup;
    RadioButton major;
    RadioButton minor;
    RadioButton blues;
    RadioButton pentatonic;
    ProgressBar prog;
    Chromatic chromatic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner menu for root note
        Spinner noteSpinner = (Spinner) findViewById(R.id.note_spinner);
        Spinner scaleSpinner = (Spinner) findViewById(R.id.scale_spinner);
        noteView = (TextView) findViewById(R.id.noteView);
        noteView.setText("Scale appears here");
        //How much of this could be replaced by ViewModel?
        //ArrayAdapter for noteSpinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.keys,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noteSpinner.setAdapter(adapter);
        noteSpinner.setOnItemSelectedListener(this);
        //ArrayAdapter for scaleSpinner
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.scales,
                android.R.layout.simple_spinner_item);
        scaleSpinner.setAdapter(adapter1);
        scaleSpinner.setOnItemSelectedListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        rootNote = (String) parent.getItemAtPosition(position);
        chromatic = new Chromatic(rootNote);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        rootNote = "C";
    }


    public void printScales(ArrayList<String> noteScale, TextView textView) {
        for (int i = 0; i < noteScale.size(); ++i) {
            String note = noteScale.get(i) + ",";
            textView.append(note);
        }
    }

    public void scaleError() {
        Toast.makeText(this, "Scale is empty", Toast.LENGTH_SHORT).show();
    }


}
