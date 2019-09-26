package org.d3ifcool.sicoding.materi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

public class MenuMateriAdapter extends RecyclerView.Adapter<MenuMateriAdapter.myyViewHolder> {
    public static final String EXTRA_MESSAGE = "org.d3ifcool.sicoding";
    private ArrayList<MenuMateri> menuMateriList;
    private Context mContext;

    public MenuMateriAdapter(ArrayList<MenuMateri> menuMateriList) {
        this.menuMateriList = menuMateriList;
    }

    @NonNull
    @Override
    public myyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_menu_materi_item, parent, false);
        return new myyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myyViewHolder holder, int position) {
        final MenuMateri item = menuMateriList.get(position);
        holder.judul.setText(item.getJudul());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriActivity.class);
                intent.putExtra("judul", item.getJudul());
                intent.putExtra("penjelasan", item.getDesk());
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuMateriList.size();
    }

    public class myyViewHolder extends RecyclerView.ViewHolder {
        TextView judul ;

        public myyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_judulMateri);

        }
    }
}