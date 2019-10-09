package org.d3ifcool.sicoding.materi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class LatihanAdapter extends RecyclerView.Adapter<LatihanAdapter.myyViewHolder> {
    public static final String EXTRA_MESSAGE = "org.d3ifcool.sicoding";
    private ArrayList<MenuMateri> lists;
    private Context mContext;

    public LatihanAdapter(ArrayList<MenuMateri> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public LatihanAdapter.myyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_menu_materi_item, parent, false);
        return new LatihanAdapter.myyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatihanAdapter.myyViewHolder holder, int position) {
        final MenuMateri item = lists.get(position);
        holder.judul.setText(item.getJudul());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailLatihanActivity.class);
                intent.putExtra("judul", item.getJudul());
                intent.putExtra("penjelasan", item.getDesk());
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myyViewHolder extends RecyclerView.ViewHolder {
        TextView judul ;

        public myyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tv_judulMateri);

        }
    }
}
