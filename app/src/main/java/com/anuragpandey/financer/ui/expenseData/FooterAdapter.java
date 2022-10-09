package com.anuragpandey.financer.ui.expenseData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.anuragpandey.financer.R;

import org.w3c.dom.Text;

public class FooterAdapter extends RecyclerView.Adapter<FooterAdapter.FooterViewHolder> {
    public FooterAdapter() {
    }

    @NonNull
    @Override
    public FooterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer, parent, false);
        return new FooterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FooterViewHolder holder, int position) {
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentNeeds_to_wantsFragment);
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView add;
        Button next;
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            add = itemView.findViewById(R.id.tv_add);
            next = itemView.findViewById(R.id.bt_next);
        }
    }
}
