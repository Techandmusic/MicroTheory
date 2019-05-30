package com.apps.adampate.microtheory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    String rootNote;
    Scale scale;
    int tone;
    ArrayList<String> notes;
    TextView noteView;
    Button btn;
    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.buttons);
    RadioButton major = findViewById(R.id.rb_major);
    RadioButton minor = findViewById(R.id.rb_minor);
    RadioButton blues = findViewById(R.id.rb_blues);
    RadioButton pentatonic = findViewById(R.id.rb_pentatonic);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner menu for root note
        Spinner spinner = (Spinner) findViewById(R.id.note_spinner);
        noteView = (TextView) findViewById(R.id.noteView);
        noteView.setText("Scale appears here");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.keys,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //Radio button onClicked
        radioGroup = (RadioGroup) findViewById(R.id.buttons);
        major = findViewById(R.id.rb_major);
        minor = findViewById(R.id.rb_minor);
        blues = findViewById(R.id.rb_blues);
        pentatonic = findViewById(R.id.rb_pentatonic);
        radioGroup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (minor.isChecked())
                {
                    tone = 2;
                }
                else if (blues.isChecked())
                {
                    tone = 3;
                }
                else if (pentatonic.isChecked())
                {
                    tone = 4;
                }
                else
                {
                    tone = 1;
                }

            }
        });
        btn = (Button) findViewById(R.id.scale_button);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new scaleLoader();
            }
        });





    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rb_major:
                if (checked)
                    tone = 1;
                break;
            case R.id.rb_minor:
                if (checked)
                    tone = 2;
                break;
            case R.id.rb_blues:
                if (checked)
                    tone = 3;
                break;
            case R.id.rb_pentatonic:
                if (checked)
                    tone = 4;
                break;
            default:
                Toast.makeText(this, R.string.radio_button_default, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        rootNote = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        rootNote = "C";
    }

//TODO Build chord class that takes String parameters for root note, and tonality (major, minor, etc)

    public void printScales(ArrayList<String> noteScale, TextView textView)
    {
        for (int i = 0; i < noteScale.size(); ++i) {
            String note = noteScale.get(i) + ",";
            textView.append(note);
        }
    }

    public void scaleError()
    {
        Toast.makeText(this, "Scale is empty", Toast.LENGTH_SHORT).show();
    }

    private class scaleLoader extends AsyncTask<String, String, ArrayList<String>>
    {
        public ProgressBar prog = (ProgressBar) findViewById(R.id.progressBar1);;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

        }

        @Override
        protected ArrayList doInBackground(String... strings)
        {

            prog.setVisibility(View.VISIBLE);
            scale = new Scale(rootNote, tone);
            notes = scale.getNewScale();
            return notes;
        }


        protected void onPostExecute(ArrayList<String> result)
        {
            super.onPostExecute(notes);
            prog.setVisibility(View.GONE);
            printScales(notes, noteView);
            noteView.setVisibility(View.VISIBLE);
        }
    }
}
