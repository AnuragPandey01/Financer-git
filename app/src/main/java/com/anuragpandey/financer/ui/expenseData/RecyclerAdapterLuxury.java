package com.anuragpandey.financer.ui.expenseData;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anuragpandey.financer.R;
import com.anuragpandey.financer.model.DataHolder;
import com.anuragpandey.financer.model.ExpenseData;

import java.util.ArrayList;

public class RecyclerAdapterLuxury extends RecyclerView.Adapter<RecyclerAdapterLuxury.ListViewHolder> {
    ArrayList<ExpenseData> list;
    public static int[] amountList = new int[15];
    int a;

    public RecyclerAdapterLuxury(ArrayList<ExpenseData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_data_itemview, parent, false);
        return new RecyclerAdapterLuxury.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        /*amountList[position] = */
        int pos = position;
        holder.name.setText(list.get(position).getExpenseName());
        holder.amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                a = Integer.parseInt(holder.amount.getText().toString());
                amountList[pos] = a;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        EditText amount;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_expense_name);
            amount = itemView.findViewById(R.id.et_expense_amount);
        }
    }
}
