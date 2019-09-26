package org.d3ifcool.sicoding.materi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContohAdapter extends RecyclerView.Adapter<ContohAdapter.mymyViewHolder> {

    private ArrayList<MenuMateri> menuMateriList;

    public ContohAdapter(ArrayList<MenuMateri> menuMateriList) {
        this.menuMateriList = menuMateriList;
    }

    @NonNull
    @Override
    public mymyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_detail_latihan, parent, false);
        return new ContohAdapter.mymyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mymyViewHolder holder, int position) {
        final MenuMateri item = menuMateriList.get(position);
        holder.judul.setText(item.getJudul());
        holder.deskripsi.setText(item.getDesk());
    }

    @Override
    public int getItemCount() {
        return menuMateriList.size();
    }

    public class mymyViewHolder extends RecyclerView.ViewHolder {
        TextView judul, deskripsi;

        public mymyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_judulDetail);
            deskripsi = itemView.findViewById(R.id.tV_description);
        }
    }
}
