package com.example.alfabet.chart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_main);

        CandleStickChart candleStickChart = (CandleStickChart) findViewById(R.id.chart);

        ArrayList<CandleStickChart> entries = new ArrayList<>();
        entries.add(new CandleEntry(4f, 0));
        entries.add(new CandleEntry(8f, 1));
        entries.add(new CandleEntry(6f, 2));
        entries.add(new CandleEntry(12f, 3));
        entries.add(new CandleEntry(18f, 4));
        entries.add(new CandleEntry(9f, 5));
        entries.add(new CandleEntry(14f, 6));

        CandleDataSet dataSet = new CandleDataSet(entries, "# of Cholesterol");

        ArrayList<String> labels = new ArrayList<String>()


    }
}
