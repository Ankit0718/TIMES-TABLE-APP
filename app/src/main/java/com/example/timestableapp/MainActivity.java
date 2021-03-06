package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int j=1;j<=10;j++){
            timesTableContent.add(timesTableNumber +"  X  "+ j +"  =  "+ Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar tableSeekBar = (SeekBar) findViewById(R.id.tableSeekBar);
        listView = (ListView) findViewById(R.id.timesListView);
        int max=20;
        int startPosition =10;
        tableSeekBar.setMax(max);
        tableSeekBar.setProgress(startPosition);
        generateTimesTable( startPosition);

        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timesTableNumber;
                if (i<min){
                    timesTableNumber = min;
                    tableSeekBar.setProgress(min);
                }
                else{
                    timesTableNumber = i;
                }
                generateTimesTable( timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}