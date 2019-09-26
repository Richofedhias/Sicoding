package org.d3ifcool.sicoding.materi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ListViewHolder> {
    private ArrayList<MenuMateri> menuMateriList;

    public DetailAdapter(ArrayList<MenuMateri> menuMateriList) {
        this.menuMateriList = menuMateriList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_detail_materi, parent, false);
        return new DetailAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final MenuMateri item = menuMateriList.get(position);
        holder.judul.setText(item.getJudul());
        holder.deskripsi.setText(item.getDesk());
    }

    @Override
    public int getItemCount() {
        return menuMateriList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView judul, deskripsi;

        public ListViewHolder(View view) {
            super(view);
            judul = view.findViewById(R.id.tV_judulDetail);
            deskripsi = view.findViewById(R.id.tV_description);
        }
    }
}
