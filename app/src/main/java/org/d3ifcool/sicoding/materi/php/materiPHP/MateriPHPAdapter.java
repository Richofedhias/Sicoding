package org.d3ifcool.sicoding.materi.php.materiPHP;

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

public class MateriPHPAdapter extends RecyclerView.Adapter<MateriPHPAdapter.myViewholder> {

    Context context;
    ArrayList<DataMateriPHP> lists;

    public MateriPHPAdapter(Context context, ArrayList<DataMateriPHP> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public MateriPHPAdapter.myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_materi_php_item,parent,false);
        return new MateriPHPAdapter.myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriPHPAdapter.myViewholder holder, int position) {
        final DataMateriPHP materi= lists.get(position);

        holder.judulMateri.setText(materi.getJudul());
        holder.descMateri.setText(materi.getDesk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriPHPActivity.class);
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

    class myViewholder extends RecyclerView.ViewHolder {
        TextView judulMateri, descMateri;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            judulMateri = itemView.findViewById(R.id.tv_judulMateri_php);
            descMateri = itemView.findViewById(R.id.tv_deskMateri_php);
        }
    }
}
