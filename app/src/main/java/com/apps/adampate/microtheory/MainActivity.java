package com.apps.adampate.microtheory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private String rootNote;
    private Chromatic scale;
    private int tone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner menu for root note
        Spinner spinner = (Spinner) findViewById(R.id.note_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.keys,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //Radio button onClicked
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.buttons);

        Button btn = (Button) findViewById(R.id.scale_button);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scale = new Chromatic(rootNote);
            }
        });


    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rb_major:
                tone = 1;
                break;
            case R.id.rb_minor:
                tone = 2;
                break;
            case R.id.rb_blues:
                tone = 3;
                break;
            case R.id.rb_pentatonic:
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

    }

//TODO Build chord class that takes String parameters for root note, and tonality (major, minor, etc)

}
