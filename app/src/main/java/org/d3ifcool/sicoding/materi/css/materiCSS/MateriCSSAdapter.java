package org.d3ifcool.sicoding.materi.css.materiCSS;

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

public class MateriCSSAdapter extends RecyclerView.Adapter<MateriCSSAdapter.myViewholder> {

    Context context;
    ArrayList<DataMateriCSS> materiCSS;

    public MateriCSSAdapter(Context context, ArrayList<DataMateriCSS> materiCSS) {
        this.context = context;
        this.materiCSS = materiCSS;
    }

    @NonNull
    @Override
    public MateriCSSAdapter.myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_materi_css_item, parent,false);
        return new MateriCSSAdapter.myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriCSSAdapter.myViewholder holder, int position) {
        final DataMateriCSS materi= materiCSS.get(position);

        holder.judulMateri.setText(materi.getJudul());
        holder.descMateri.setText(materi.getDesk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriCSSActivity.class);
                intent.putExtra("judul", materi.getJudul());
                intent.putExtra("deskripsi", materi.getDesk());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return materiCSS.size();
    }

    class myViewholder extends RecyclerView.ViewHolder {
        TextView judulMateri, descMateri;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            judulMateri = itemView.findViewById(R.id.tv_judulMateri_css);
            descMateri = itemView.findViewById(R.id.tv_deskMateri_css);
        }
    }
}
