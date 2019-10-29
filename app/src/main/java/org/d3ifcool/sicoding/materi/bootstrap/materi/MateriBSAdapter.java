package org.d3ifcool.sicoding.materi.bootstrap.materi;

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

public class MateriBSAdapter extends RecyclerView.Adapter<MateriBSAdapter.myViewholder> {
    Context context;
    ArrayList<DataMateriBS> lists;

    public MateriBSAdapter(Context context, ArrayList<DataMateriBS> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_materi_bs_item, parent,false);
        return new MateriBSAdapter.myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        final DataMateriBS materi= lists.get(position);

        holder.judulMateri.setText(materi.getJudul());
        holder.descMateri.setText(materi.getDesk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriBSActivity.class);
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
            judulMateri = itemView.findViewById(R.id.tv_judulMateri_bs);
            descMateri = itemView.findViewById(R.id.tv_deskMateri_bs);
        }
    }
}
