package org.d3ifcool.sicoding.materi.mySQL.latihan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import thereisnospon.codeview.CodeView;

import com.squareup.picasso.Picasso;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.JSON.latihan.DataLatihanJSON;
import org.d3ifcool.sicoding.materi.JSON.latihan.DetailLatihanJSONActivity;
import org.d3ifcool.sicoding.materi.JSON.latihan.LatihanJSONAdapter;

import java.util.ArrayList;

public class LatihanMYSQLAdapter extends RecyclerView.Adapter<LatihanMYSQLAdapter.myyViewHolder> {
    private ArrayList<DataLatihanMYSQL> lists;
    private Context mContext;

    public LatihanMYSQLAdapter(ArrayList<DataLatihanMYSQL> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_latihan_mysql_item, parent, false);
        return new LatihanMYSQLAdapter.myyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myyViewHolder holder, int position) {
        final DataLatihanMYSQL item = lists.get(position);
        holder.judul.setText(item.getJudul());
        holder.desk.showCode(item.getDesk());

        Picasso.get().load(lists.get(position).getImages()).into(holder.images);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), DetailLatihanMYSQLActivity.class);
//                intent.putExtra("judul", item.getJudul());
//                intent.putExtra("penjelasan", item.getDesk());
//                view.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myyViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        CodeView desk;
        ImageView images;

        public myyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_contoh_mysql);
            desk = itemView.findViewById(R.id.tV_Latihan_mysql);
            images = itemView.findViewById(R.id.iV_contoh_mysql);
        }
    }
}
