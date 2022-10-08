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
import android.widget.ImageView;

import com.anuragpandey.financer.R;
import com.anuragpandey.financer.model.ExpenseData;

import java.util.ArrayList;


public class FragmentNeeds extends Fragment {
    private static final String TAG = "FragmentNeeds";
    RecyclerView recyclerView;
    ArrayList<ExpenseData> list = new ArrayList<>();
    RecyclerAdapter adapter = new RecyclerAdapter(list);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_needs, container, false);
        recyclerView = view.findViewById(R.id.rv_needs);

        view.findViewById(R.id.bt_needs_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentNeeds_to_wantsFragment);
            }
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new ExpenseData("Rent"));
        list.add(new ExpenseData("Maintaince"));
        list.add(new ExpenseData("Electricity"));
        list.add(new ExpenseData("Rent"));

    }
}