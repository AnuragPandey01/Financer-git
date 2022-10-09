package com.anuragpandey.financer.ui.expenseData;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anuragpandey.financer.R;
import com.anuragpandey.financer.model.DataHolder;
import com.anuragpandey.financer.model.ExpenseData;

import java.util.ArrayList;


public class LuxuryFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ExpenseData> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_luxury, container, false);
        recyclerView = view.findViewById(R.id.rv_luxury);
        RecyclerAdapterLuxury adapter = new RecyclerAdapterLuxury(list);


        view.findViewById(R.id.bt_luxury_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                for(int i = 0; i<15; i++){
                    DataHolder.luxuryTotalAmount += RecyclerAdapterLuxury.amountList[i];
                    Log.d("bitch", String.valueOf(DataHolder.luxuryTotalAmount));
                }
                Navigation.findNavController(view).navigate(R.id.action_luxuryFragment_to_resultFragment);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new ExpenseData("Eating out"));
        list.add(new ExpenseData("Vehicle Emi"));
        list.add(new ExpenseData("Jewellery"));

    }
}