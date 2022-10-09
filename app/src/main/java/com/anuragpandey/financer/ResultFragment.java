package com.anuragpandey.financer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anuragpandey.financer.R;
import com.anuragpandey.financer.model.DataHolder;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class ResultFragment extends Fragment {

    PieChart pieChart;
    LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        pieChart = view.findViewById(R.id.pie_chart);
        lineChart = view.findViewById(R.id.line_chart);
        List<PieEntry> entries = new ArrayList<>();
        int need = DataHolder.needsTotalAmount;
        int wants = DataHolder.wantsTotalAmount;
        int luxury = DataHolder.luxuryTotalAmount;
        int total = DataHolder.totalIncome;
        int saving = total -(need+wants+luxury);
        Log.d("bitch", "onCreateView: "+need +" "+wants+" "+luxury+" "+total);
        entries.add(new PieEntry( (need/(float)total)*100, "Needs"));
        entries.add(new PieEntry((wants/(float)total)*100, "wants"));
        entries.add(new PieEntry((luxury/(float)total)*100, "luxury"));
        entries.add(new PieEntry((saving/(float)total)*100, "saving"));
        PieDataSet set = new PieDataSet(entries, "Your Income");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(set);
        pieChart.setData(data);
        setUpLineChart(saving ,lineChart  );
        return view;
    }

    public static void setUpLineChart(int saving,LineChart lineChart){
        List<Entry> mfEntries = new ArrayList<>();
        mfEntries.add(new Entry(0,saving));
        float increasedSavingMf = saving;
        for (int i = 1; i < 15; i++) {
            increasedSavingMf = (float) ((float)increasedSavingMf+(0.11*increasedSavingMf));
            mfEntries.add(new Entry(i,increasedSavingMf));

        }
        LineDataSet dataSetMf = new LineDataSet(mfEntries, "Increased by MF");
        dataSetMf.setLineWidth(4.0f);
        List<Entry> debtEntries = new ArrayList<>();
        debtEntries.add(new Entry(0,saving));
        float increasedSavingDebt = saving;
        for (int i = 1; i < 15; i++) {
            increasedSavingDebt = (float) ((float)increasedSavingDebt+(0.6*increasedSavingDebt));
            debtEntries.add(new Entry(i,increasedSavingDebt));
        }
        LineDataSet dataSetDebt = new LineDataSet(mfEntries, "Increased by DebtFund");
        dataSetDebt.setLineWidth(4.0f);
        dataSetDebt.setColors(R.color.black);
        lineChart.setData(new LineData(dataSetDebt, dataSetMf));

    }

}