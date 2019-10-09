package org.d3ifcool.sicoding.beranda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.ListMateriActivity;

import java.util.ArrayList;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.myViewHolder> {

    Context context;
    ArrayList<AndroidList> isiAndroidlist;

    public AndroidAdapter(Context context, ArrayList<AndroidList> isiAndroidlist) {
        this.context = context;
        this.isiAndroidlist = isiAndroidlist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_android_language_item, parent, false);
        AndroidAdapter.myViewHolder viewHolder = new AndroidAdapter.myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.nama.setText(isiAndroidlist.get(position).getNamaAndLanguage());
        holder.logo.setImageResource(isiAndroidlist.get(position).getLogoAndLanguage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (position == 0) {
                    intent = new Intent(view.getContext(), ListMateriActivity.class);
                    view.getContext().startActivity(intent);
                }
//                else if (position == 1) {
//                    intent = new Intent(view.getContext(), ListMateriActivity.class);
//                    view.getContext().startActivity(intent);
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return isiAndroidlist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        ImageView logo;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tV_namaAndLanguage);
            logo = itemView.findViewById(R.id.iV_logoAndLanguage);
        }
    }
}
