package com.anuragpandey.financer.ui.expenseData;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anuragpandey.financer.R;
import com.anuragpandey.financer.model.DataHolder;
import com.anuragpandey.financer.model.ExpenseData;

import java.util.ArrayList;

public class FragmentNeeds extends Fragment {
    private static final String TAG = "FragmentNeeds";
    RecyclerView recyclerView;
    ArrayList<ExpenseData> list = new ArrayList<>();
    RecyclerAdapterNeeds adapter = new RecyclerAdapterNeeds(list);
    FooterAdapter footerAdapter = new FooterAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_needs, container, false);
        recyclerView = view.findViewById(R.id.rv_needs);

        view.findViewById(R.id.bt_needs_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for(int i = 0; i<15; i++){
                    DataHolder.needsTotalAmount += RecyclerAdapterNeeds.amountList[i];
                    Log.d("bitch", String.valueOf(DataHolder.needsTotalAmount));
                }
                Navigation.findNavController(view).navigate(R.id.action_fragmentNeeds_to_wantsFragment);
            }

        });
        view.findViewById(R.id.tv_add_needs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.clear();
        list.add(new ExpenseData("Rent"));
        list.add(new ExpenseData("Maintaince"));
        list.add(new ExpenseData("Electricity"));
        list.add(new ExpenseData("Groceries"));

        adapter.notifyDataSetChanged();

    }
    public void customDialog() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(requireContext());
        View myview = LayoutInflater.from(requireContext()).inflate(R.layout.add_data, null);
        AlertDialog dialog = myDialog.create();
        dialog.setView(myview);

        EditText title = myview.findViewById(R.id.et_add_title);
        Button bt_save = myview.findViewById(R.id.bt_add_save);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //list.clear();
                String mTitle = title.getText().toString().trim();

                if(TextUtils.isEmpty(mTitle)) {
                    title.setError("field empty");
                    return;
                }

                list.add(new ExpenseData(mTitle));

                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}