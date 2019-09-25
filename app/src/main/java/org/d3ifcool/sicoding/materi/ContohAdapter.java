package org.d3ifcool.sicoding.materi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContohAdapter extends RecyclerView.Adapter<ContohAdapter.myViewHolder> {

    private ArrayList<MenuMateri> menuMateriList;

    public ContohAdapter(ArrayList<MenuMateri> menuMateriList) {
        this.menuMateriList = menuMateriList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_contoh_item, parent, false);
        return new ContohAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        MenuMateri item = menuMateriList.get(position);
        holder.judul.setText(item.getJudul());
    }

    @Override
    public int getItemCount() {
        return menuMateriList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView judul ;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_contoh);

        }
    }
}
