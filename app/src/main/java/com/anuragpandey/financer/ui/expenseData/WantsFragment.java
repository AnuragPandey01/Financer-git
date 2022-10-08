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
import com.anuragpandey.financer.model.ExpenseData;

import java.util.ArrayList;

public class WantsFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ExpenseData> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wants, container, false);
        recyclerView = view.findViewById(R.id.rv_wants);
        RecyclerAdapter adapter = new RecyclerAdapter(list);

        view.findViewById(R.id.bt_wants_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_wantsFragment_to_luxuryFragment);
            }
        });
        Log.d("mmmmm", "onCreateView: "+ recyclerView+adapter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new ExpenseData("sdsddsds"));
        list.add(new ExpenseData("dsd"));
        list.add(new ExpenseData("Elecdsdstricity"));
        list.add(new ExpenseData("dsds"));
    }
}