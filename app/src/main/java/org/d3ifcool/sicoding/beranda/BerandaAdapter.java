package org.d3ifcool.sicoding.beranda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class BerandaAdapter extends RecyclerView.Adapter<BerandaAdapter.myViewHolder> {

    ArrayList<IsiBeranda> isiBerandalist;

    public BerandaAdapter(ArrayList<IsiBeranda> isiBerandalist) {
        this.isiBerandalist = isiBerandalist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_button_language, parent, false);
        myViewHolder viewHolder = new myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.nama.setText(isiBerandalist.get(position).getNamaLanguage());
        holder.logo.setImageResource(isiBerandalist.get(position).getLogoLanguage());
    }

    @Override
    public int getItemCount() {
        return isiBerandalist.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        ImageView logo;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tV_namaLanguage);
            logo = itemView.findViewById(R.id.iV_logoLanguage);
        }
    }
}
