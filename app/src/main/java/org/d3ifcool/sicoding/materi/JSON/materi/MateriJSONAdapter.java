package org.d3ifcool.sicoding.materi.JSON.materi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.php.materiPHP.DataMateriPHP;
import org.d3ifcool.sicoding.materi.php.materiPHP.DetailMateriPHPActivity;
import org.d3ifcool.sicoding.materi.php.materiPHP.MateriPHPAdapter;

import java.util.ArrayList;

public class MateriJSONAdapter extends RecyclerView.Adapter<MateriJSONAdapter.myViewholder> {
    Context context;
    ArrayList<DataMateriJSON> lists;

    public MateriJSONAdapter(Context context, ArrayList<DataMateriJSON> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_materi_json_item,parent,false);
        return new MateriJSONAdapter.myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        final DataMateriJSON materi= lists.get(position);

        holder.judulMateri.setText(materi.getJudul());
        holder.descMateri.setText(materi.getDesk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriJSONActivity.class);
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
            judulMateri = itemView.findViewById(R.id.tv_judulMateri_json);
            descMateri = itemView.findViewById(R.id.tv_deskMateri_json);
        }
    }
}
