package org.d3ifcool.sicoding.materi.javascript.materi;

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

public class MateriJSAdapter extends RecyclerView.Adapter<MateriJSAdapter.myViewholder> {
    Context context;
    ArrayList<DataMateriJS> lists;

    public MateriJSAdapter(Context context, ArrayList<DataMateriJS> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_materi_js_item,parent,false);
        return new MateriJSAdapter.myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        final DataMateriJS materi= lists.get(position);

        holder.judulMateri.setText(materi.getJudul());
        holder.descMateri.setText(materi.getDesk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriJSActivity.class);
                intent.putExtra("judul", materi.getJudul());
                intent.putExtra("deskripsi", materi.getDesk());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myViewholder extends RecyclerView.ViewHolder {
        TextView judulMateri, descMateri;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            judulMateri = itemView.findViewById(R.id.tv_judulMateri_js);
            descMateri = itemView.findViewById(R.id.tv_deskMateri_js);
        }
    }
}
