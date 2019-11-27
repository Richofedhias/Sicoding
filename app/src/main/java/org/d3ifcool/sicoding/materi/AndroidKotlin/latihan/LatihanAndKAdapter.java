package org.d3ifcool.sicoding.materi.AndroidKotlin.latihan;

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
import org.d3ifcool.sicoding.materi.AndroidJava.latihan.DataLatihanAndJ;
import org.d3ifcool.sicoding.materi.AndroidJava.latihan.DetailLatihanAndJActivity;
import org.d3ifcool.sicoding.materi.AndroidJava.latihan.LatihanAndJAdapter;

import java.util.ArrayList;

public class LatihanAndKAdapter extends RecyclerView.Adapter<LatihanAndKAdapter.myyViewHolder> {
    private ArrayList<DataLatihanAndK> lists;
    private Context mContext;

    public LatihanAndKAdapter(ArrayList<DataLatihanAndK> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_latihan_andk_item, parent, false);
        return new LatihanAndKAdapter.myyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myyViewHolder holder, int position) {
        final DataLatihanAndK item = lists.get(position);
        holder.judul.setText(item.getJudul());
        holder.desk.showCode(item.getDesk());

        Picasso.get().load(lists.get(position).getImages()).into(holder.images);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), DetailLatihanAndKActivity.class);
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
            judul = itemView.findViewById(R.id.tV_contoh_kotlin);
            desk = itemView.findViewById(R.id.tV_Latihan_kotlin);
            images = itemView.findViewById(R.id.iV_contoh_kotlin);
        }
    }
}
