package com.anuragpandey.financer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.anuragpandey.financer.model.DataHolder;

public class FragmentBasicData extends Fragment {
    EditText etMonthlyIncome;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_data, container, false);
        etMonthlyIncome = view.findViewById(R.id.et_monthly_salary);
        view.findViewById(R.id.bt_basic_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DataHolder.totalIncome = Integer.parseInt(etMonthlyIncome.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_fragmentBasicData_to_fragmentNeeds);
            }
        });
        return view;
    }
}