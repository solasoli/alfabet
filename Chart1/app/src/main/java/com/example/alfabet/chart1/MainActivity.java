package com.example.alfabet.chart1;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainlayout; //nyebutin layout dolooo
    private LineChart mChart; //nama chart

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainlayout = (ConstraintLayout) findViewById(R.id.mainlayout);

        mChart = new LineChart(this); //specify jenis chart

        mainlayout.addView(mChart); //masukin chart ke layout

        mChart.setDescription(""); //deskripsi kosong
        mChart.setNoDataTextDescription("No data"); //idem sama diatas
        mChart.setTouchEnabled(true); //bisa disentuh
        mChart.setHighlightPerTapEnabled(true); //highlight
        mChart.setDragEnabled(true); //bisa di drag dongs
        mChart.setScaleEnabled(true); //enable scale duh!
        mChart.setDrawGridBackground(false); //grid bos griddd

        mChart.setPinchZoom(true); //cubit2 zoom mesra

        mChart.setBackgroundColor(Color.LTGRAY); //warna bg

        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE); //warna lagi

        mChart.setData(data);

        Legend l = mChart.getLegend();

        l.setForm(Legend.LegendForm.LINE); //form
        l.setTextColor(Color.WHITE);


        //axis
        XAxis xl = mChart.getXAxis();
        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);

        YAxis yl = mChart.getAxisLeft();
        yl.setTextColor(Color.WHITE);
        yl.setAxisMaxValue(120f);
        yl.setDrawGridLines(true);


        YAxis yl2 = mChart.getAxisRight();
        yl2.setEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addEntry();
                        }
                    });

                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {

                    }
                }

            }
        }).start();
    }

    private void addEntry() {

        LineData data = mChart.getData();

        if (data != null) {

            LineDataSet set = (LineDataSet) data.getDataSetByIndex(0);

            if (set == null) {

                set = createSet();
                data.addDataSet(set);
            }
            //random ini ngasal aja
            data.addXValue("");
            data.addEntry(new Entry(Math.random() * 75) +75f, set.getEntryCount(), 0);


            //notifikasi pak
            mChart.notifyDataSetChanged();

            mChart.setVisibleXRange("float");
            mChart.moveViewToX(data.getXValCount()  -  7);
        }
    }

    private  LineDataSet CreateSet() {

        LineDataSet set = new LineDataSet(null, "SPL Db");
        set.setDrawCubic(true);
        set.setCubicIntensity(0.2f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setLineWidth(2f);
        set.setCircleSize(4f);
        set.setFillAlpha(65);
        set.setFillColor(Color.red(244, 117, 177));
        set.setValueTextColor(Color.WHITE);
        set.setValueTextSize(10f);

    }
}





